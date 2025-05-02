package networking.create;

import dtos.Request;
import dtos.create.CreateActivityRequest;
import dtos.create.CreateClubRequest;
import dtos.create.CreateEventRequest;
import networking.SocketService;

public class SocketCreateClient implements CreateClient
{
  @Override public void createActivity(CreateActivityRequest activity)
  {
    Request request = new Request("create","create",activity);
    SocketService.sendRequest(request);
  }

  public void createClub(CreateClubRequest club)
  {
    Request request = new Request("create","createClub",club);
    SocketService.sendRequest(request);
  }

  public void createEvent(CreateEventRequest event)
  {
    Request request = new Request("create","createEvent",event);
    SocketService.sendRequest(request);
  }
}
