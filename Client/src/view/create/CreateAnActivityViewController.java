package view.create;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import view.common.Controller;
import viewModel.CreateAnActivityVM;

import java.time.LocalDate;

public class CreateAnActivityViewController implements Controller
{
  @FXML private TextField nameInput;
  @FXML private TextField addressInput;
  @FXML private DatePicker dateInput;
  @FXML private ComboBox<String> timeComboBox;
  @FXML private ComboBox<String> cityComboBox;
  @FXML private ComboBox<String> typeComboBox;
  @FXML private TextField priceInput;
  @FXML private TextField descriptionInput;
  @FXML private Button saveButton;

  private final CreateAnActivityVM viewModel;

  public void onSaveButton()
  {
    String name = nameInput.getText();
    String address = addressInput.getText();
    LocalDate date = dateInput.getValue();
    String time = timeComboBox.getValue();
    String city = cityComboBox.getValue();
    String type = typeComboBox.getValue();

    if (name.isEmpty() || address.isEmpty() || date == null || time == null
        || city == null || type == null)
    {
      showAlert("Error", "Please fill all the required fields");
      return;
    }
    viewModel.save();
  }

  private void showAlert(String title, String message)
  {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }

  public CreateAnActivityViewController(CreateAnActivityVM vm)
  {
    this.viewModel = vm;
  }

  public void initialize(){
    nameInput.textProperty().bindBidirectional(viewModel.nameProperty());
    addressInput.textProperty().bindBidirectional(viewModel.addressProperty());
    dateInput.valueProperty().bindBidirectional(viewModel.dateProperty());
    timeComboBox.setItems(viewModel.getTimes());
    timeComboBox.valueProperty().bindBidirectional(viewModel.timeProperty());
    cityComboBox.setItems(viewModel.getCities());
    cityComboBox.valueProperty().bindBidirectional(viewModel.cityProperty());
    typeComboBox.setItems(viewModel.getTypes());
    typeComboBox.valueProperty().bindBidirectional(viewModel.typeProperty());
    priceInput.textProperty().bindBidirectional(viewModel.priceProperty());
    descriptionInput.textProperty().bindBidirectional(
        viewModel.descriptionProperty());
  }

}
