package networking.search;

import dtos.Request;
import dtos.search.SearchRequest;
import model.entities.Activity;
import networking.SocketService;

import java.util.List;

public class SocketSearchClient implements SearchClient
{
  @Override public List<Activity> search(SearchRequest request)
  {
    Request req = new Request("search","search" ,request);
    Object response = SocketService.sendRequest(req);
    return (List<Activity>) response;
  }
}
