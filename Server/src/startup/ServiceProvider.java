package startup;

import networking.requestHandlers.CreateRequestHandler;
import networking.requestHandlers.RequestHandler;
import networking.requestHandlers.SearchRequestHandler;
import persistance.create.CreateDAO;
import persistance.create.CreatePostgresDAO;
import persistance.search.CreateSearchDAO;
import services.create.CreateService;
import services.create.CreateServiceImpl;
import services.search.SearchService;
import services.search.SearchServiceImpl;
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

  public RequestHandler getSearchRequestHandler(CreateSearchDAO createSearchDao)
  {
    return new SearchRequestHandler(getSearchService(), createSearchDao);
  }
  private static CreateService getCreateService()
  {
    return new CreateServiceImpl(getCreateDao());
  }
  private static SearchService getSearchService()
  {
    return new SearchServiceImpl(getCreateSearchDao());
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

  private static CreateSearchDAO getCreateSearchDao()
  {
    try
    {
      return CreateSearchDAO.getInstance();
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
