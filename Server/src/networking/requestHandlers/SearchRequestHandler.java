package networking.requestHandlers;

import dtos.search.ActivityDTO;
import dtos.search.SearchRequest;
import dtos.search.SearchResponse;
import model.entities.Activity;
import persistance.search.CreateSearchDAO;
import services.search.SearchService;
import services.search.SearchServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class SearchRequestHandler implements RequestHandler {
  private final SearchService searchService;

  public SearchRequestHandler(SearchService searchService,
      CreateSearchDAO createSearchDao) {
    this.searchService = new SearchServiceImpl(getCreateSearchDao(
        createSearchDao));
  }

  @Override
  public Object handle(String action, Object payload) throws SQLException {
    if (!action.equals("search")) {
      throw new IllegalArgumentException("Unknown action: " + action);
    }

    SearchRequest searchRequest = (SearchRequest) payload;
    List<Activity> activities = searchService.search(searchRequest.city(), searchRequest.type());
    List<ActivityDTO> activityDTOs = activities.stream()
        .map(this::convertToDTO)
        .collect(Collectors.toList());

    return new SearchResponse(activityDTOs);
  }

  private ActivityDTO convertToDTO(Activity activity) {
    return new ActivityDTO(
        activity.getId(),
        activity.getName(),
        activity.getAddress(),
        activity.getType(),
        activity.getCity(),
        activity.getMeetingDate(),
        activity.getMeetingTime(),
        activity.getDescription()
    );
  }

  public CreateSearchDAO getCreateSearchDao(CreateSearchDAO createSearchDao)
  {
    return createSearchDao;
  }
}