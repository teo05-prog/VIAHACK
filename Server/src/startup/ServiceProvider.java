package startup;

import networking.requestHandlers.CreateRequestHandler;
import networking.requestHandlers.RequestHandler;
import persistance.create.CreateDAO;
import persistance.create.CreatePostgresDAO;
import services.create.CreateService;
import services.create.CreateServiceImpl;
import utilities.ConsoleLogger;
import utilities.LogLevel;
import utilities.Logger;

import java.sql.SQLException;

public class ServiceProvider
{
  public RequestHandler getCreateRequestHandler()
  {
    return new CreateRequestHandler(getCreateService());
  }
  private static CreateService getCreateService()
  {
    return new CreateServiceImpl(getCreateDao());
  }

  private static CreateDAO getCreateDao()
  {
    try
    {
      return CreatePostgresDAO.getInstance();
    }
    catch (SQLException e)
    {
      throw new RuntimeException("Failed to initialize DAO", e); // or handle as needed
    }
  }
  public Logger getLogger()
  {
    return new ConsoleLogger(LogLevel.INFO);
  }
}
