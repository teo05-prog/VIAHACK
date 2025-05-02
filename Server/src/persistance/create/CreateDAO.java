package persistance.create;

import model.entities.Club;
import model.entities.Event;

import java.util.List;

public interface CreateDAO
{
  public Club createClub(String name, String type, String address, String city, int members, String meetingDate,
      String meetingTime, String description);

  public Event createEvent(String name, String type, String address, String city, String meetingDate,
      String meetingTime, int price, String description);

  public Club readByClubId(int id);

  public Event readByEventId(int id);

  public List<Club> readByName(String name);

  public List<Event> readByEventName(String name);

  public void updateClub(Club club);

  public void updateEvent(Event event);

  public void deleteClub(Club club);

  public void deleteEvent(Event event);
}
