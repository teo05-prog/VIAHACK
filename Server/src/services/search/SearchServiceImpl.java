package services.search;

import model.entities.Activity;
import persistance.search.SearchDAO;
import persistance.search.CreateSearchDAO;

import java.sql.SQLException;
import java.util.List;

public class SearchServiceImpl implements SearchService {
  private final SearchDAO searchDAO;

  public SearchServiceImpl(CreateSearchDAO createSearchDao) {
    try {
      this.searchDAO = CreateSearchDAO.getInstance();
    } catch (SQLException e) {
      throw new RuntimeException("Could not initialize search service", e);
    }
  }

  @Override
  public List<Activity> search(String city, String type) {
    return searchDAO.search(city, type);
  }
}
