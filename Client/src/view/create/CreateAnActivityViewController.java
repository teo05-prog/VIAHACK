package view.create;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;

public class CreateAnActivityViewController
{
  @FXML
  private ComboBox<String> cityComboBox;
  @FXML
  private ComboBox<String> typeComboBox;
  @FXML
  private Button createAnActivityButton;
  @FXML
  private TableColumn<String> cityColumn;
  @FXML
  private TableColumn<String> nameColumn;
  @FXML
  private TableColumn typeColumn;
  @FXML
  private TableColumn addressColumn;
  @FXML
  private TableColumn dateColumn;
  @FXML
  private TableColumn timeColumn;
  @FXML
  private TableColumn priceColumn;

}
