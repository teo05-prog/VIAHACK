package startup;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import networking.search.SearchClient;
import networking.search.SocketSearchClient;
import networking.create.CreateClient;
import networking.create.SocketCreateClient;
import view.search.SearchViewController;
import viewModel.CreateAnActivityVM;
import viewModel.SearchVM;
import view.common.Controller;

import java.io.IOException;

public class ViewHandler 
{
  private static Stage stage;

  public ViewHandler(Stage stage)
  {
    this.stage = stage;
  }
  
  public void start()
  {
    showView(ViewType.SEARCH);
    stage.show();
  }

  public static void showView(ViewType viewToShow)
  {
    try
    {
      switch (viewToShow)
      {
        case SEARCH -> openSearchView();
        case CREATE -> openCreateView();
        default -> throw new RuntimeException("View not found.");
      }
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public static void openSearchView() throws IOException
  {
    SearchClient client = new SocketSearchClient();
    SearchVM vm = new SearchVM(client);
    SearchViewController controller = new SearchViewController(vm);
    String viewTitle = "Search";
    String viewSubPath = "search/SearchView.fxml";
    openView(viewTitle, viewSubPath, controller);
  }

  public static void openCreateView()
  {
    CreateClient client = new SocketCreateClient();
    CreateAnActivityVM = new CreateAnActivityVM(client);
    SearchViewController controller = new SearchViewController(vm);
    String viewTitle = "Search";
    String viewSubPath = "search/SearchView.fxml";
    openView(viewTitle, viewSubPath, controller);
  }

  public static void openDescriptionView()

  private static void openView(String viewTitle, String viewSubPath, Controller controller) throws IOException
  {
    FXMLLoader fxmlLoader = new FXMLLoader(ViewHandler.class.getResource("../view/" + viewSubPath));
    fxmlLoader.setControllerFactory(ignore -> controller);

    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle(viewTitle);
    stage.setScene(scene);
  }
}
