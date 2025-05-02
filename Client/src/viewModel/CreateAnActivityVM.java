package viewModel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import networking.create.CreateClient;

import java.time.LocalDate;

public class CreateAnActivityVM
{
  private final CreateClient createService;
  private final StringProperty name = new SimpleStringProperty("");
  private final StringProperty address = new SimpleStringProperty("");
  private final ObjectProperty<LocalDate> date = new SimpleObjectProperty<>();
  private final StringProperty time = new SimpleStringProperty("");
  private final StringProperty city = new SimpleStringProperty("");
  private final StringProperty type = new SimpleStringProperty("");

  public CreateAnActivityVM(CreateClient createService)
  {
    this.createService = createService;
  }

  public StringProperty nameProperty(){
    return name;
  }

  public StringProperty addressProperty(){
    return address;
  }

  public ObjectProperty<LocalDate> dateProperty()
  {
    return date;
  }

  public StringProperty timeProperty(){
    return time;
  }

  public StringProperty cityProperty(){
    return city;
  }

  public StringProperty typeProperty() {
    return type;
  }

  public String getName(){
    return name.get();
  }

  public String getAddress(){
    return address.get();
  }

  public LocalDate getDate(){
    return date.get();
  }

  public String getTime(){
    return  time.get();
  }

  public String getCity(){
    return city.get();
  }

  public String getType(){
    return city.get();
  }

  public void save(){
    System.out.println("Saving");
    System.out.println("Name: " + getName());
    System.out.println("Address: " + getAddress());
    System.out.println("Date: " + getDate());
    System.out.println("Time: " + getTime());
    System.out.println("City: " + getCity());
    System.out.println("Type: " + getType());
  }
}
