package view.description;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import startup.ViewHandler;
import startup.ViewType;
import view.common.Controller;
import viewModel.DescriptionVM;

public class DescriptionViewController implements Controller
{
  private final DescriptionVM viewModel;

  @FXML private Label nameLabel;
  @FXML private TextField textInput;
  @FXML private Button backButton;

  public DescriptionViewController(DescriptionVM vm)
  {
    this.viewModel = vm;
  }

  public void initialize()
  {
    nameLabel.textProperty().bind(viewModel.nameProperty());
    textInput.textProperty().bind(viewModel.descriptionProperty());

    backButton.setOnAction(e -> onBackButton());
  }

  private void onBackButton()
  {
    ViewHandler.showView(ViewType.SEARCH);
  }
}
