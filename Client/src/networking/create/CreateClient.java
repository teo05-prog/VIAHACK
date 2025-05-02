package networking.create;

import dtos.create.CreateActivityRequest;
import dtos.create.CreateClubRequest;
import dtos.create.CreateEventRequest;

public interface CreateClient
{
  void createActivity(CreateActivityRequest activity);
  void createClub(CreateClubRequest club);
  void createEvent(CreateEventRequest event);
}
