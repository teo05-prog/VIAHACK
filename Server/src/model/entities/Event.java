package model.entities;

public class Event extends Activity
{
  private int price;

  public Event(int id, String name, String address, String type, String city,
      String meetingDate, String meetingTime, int price, String description)
  {
    super(id, name, address, type, city, meetingDate, meetingTime, description);
    this.price = price;
  }

  public int getPrice()
  {
    return price;
  }

  public void setPrice(int price)
  {
    this.price = price;
  }
}

