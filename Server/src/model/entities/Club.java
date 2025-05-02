package model.entities;

public class Club extends Activity
{
  private int members;

  public Club(int id, String name, String address, String type, String city,
      String meetingDate, String meetingTime, String description, int members)
  {
    super(id, name, address, type, city, meetingDate, meetingTime, description);
    this.members = members;
  }

  public int getMembers()
  {
    return members;
  }

  public void setMembers(int members)
  {
    this.members = members;
  }
}
