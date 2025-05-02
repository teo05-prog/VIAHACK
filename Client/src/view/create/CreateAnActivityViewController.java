package view.create;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import view.common.Controller;
import viewModel.CreateAnActivityVM;

import java.time.LocalDate;

public class CreateAnActivityViewController implements Controller
{
  @FXML private Label nameLabel;
  @FXML private Label addressLabel;
  @FXML private DatePicker dateInput;
  @FXML private ComboBox<String> timeComboBox;
  @FXML private ComboBox<String> cityComboBox;
  @FXML private ComboBox<String> typeComboBox;
  @FXML private Button saveButton;

  private final CreateAnActivityVM viewModel;

  public void onSaveButton()
  {
    String name = nameLabel.getText();
    String address = addressLabel.getText();
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
    nameLabel.textProperty().bind(viewModel.nameProperty());
    addressLabel.textProperty().bind(viewModel.addressProperty());
    dateInput.valueProperty().bindBidirectional(viewModel.dateProperty());
    timeComboBox.valueProperty().bindBidirectional(viewModel.timeProperty());
    cityComboBox.valueProperty().bindBidirectional(viewModel.cityProperty());
    typeComboBox.valueProperty().bindBidirectional(viewModel.typeProperty());
  }

}
