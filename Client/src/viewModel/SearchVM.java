package viewModel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.entities.Activity;
import networking.create.SocketCreateClient;
import networking.search.SearchClient;

public class SearchVM
{
  private final SearchClient searchClient;

  public SearchVM(SearchClient searchClient)
  {
    this.searchClient = searchClient;
  }

  private final ObservableList<String> cities = FXCollections.observableArrayList("Horsens",
      "Aalborg", "Holstebro", "Randers", "Vejle", "Esbjerg", "Slagelse", "Copenhagen", "Næstved", "Kolding", "Sønderborg", "Skanderborg",
      "Gladsaxe", "Aarhus", "Roskilde", "Odense", "Silkeborg", "Frederiksberg");
  private final ObservableList<String> types = FXCollections.observableArrayList("Music", "Sports", "Technology", "Art", "Literature", "Gaming",
      "Cooking", "Fitness", "Film", "Nature");

  private final StringProperty selectedCity = new SimpleStringProperty();
  private final StringProperty selectedType = new SimpleStringProperty();

  private final ObservableList<Activity> allActivities = FXCollections.observableArrayList();
  private final ObservableList<Activity> filteredActivities = FXCollections.observableArrayList();

  private final ObjectProperty<Activity> selectedActivity = new SimpleObjectProperty<>();

  public void loadActivities(){
    // database connection logic
  }

  private void applyFilters(){
    filteredActivities.setAll(allActivities.filtered(activity -> {
      boolean cityMatch = selectedCity.get() == null || selectedCity.get().equals(activity.getCity());
      boolean typeMatch = selectedType.get() == null || selectedType.get().equals(activity.getType());
      return cityMatch && typeMatch;
    }));
  }

  public void setSelectedActivity(Activity activity){
    selectedActivity.set(activity);
  }

  public Activity getSelectedActivity(){
    return  selectedActivity.get();
  }

  public ObjectProperty<Activity> selectedActivityProperty(){
    return selectedActivity;
  }

  public ObservableList<String> getCities(){
    return cities;
  }

  public ObservableList<String> getTypes(){
    return types;
  }

  public StringProperty selectedCityProperty()
  {
    return selectedCity;
  }

  public StringProperty selectedTypeProperty()
  {
    return selectedType;
  }

  public ObservableList<Activity> getFilteredActivities()
  {
    return filteredActivities;
  }
}
