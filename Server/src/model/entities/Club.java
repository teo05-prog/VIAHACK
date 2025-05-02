package model.entities;

public class Club extends Activity
{
  private String name;
  private String type;
  private String address;
  private String city;
  private int members;
  private String meetingDate;
  private String meetingTime;
  private int price;
  private String description;

  public Club(String name, String type, String address, String city,
      int members, String meetingDate, String meetingTime, int price,
      String description)
  {
    this.name = name;
    this.type = type;
    this.address = address;
    this.city = city;
    this.meetingDate = meetingDate;
    this.meetingTime = meetingTime;
    this.price = price;
    this.description = description;
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

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  public String getMeetingDate()
  {
    return meetingDate;
  }

  public void setMeetingDate(String meetingDate)
  {
    this.meetingDate = meetingDate;
  }

  public String getMeetingTime()
  {
    return meetingTime;
  }

  public void setMeetingTime(String meetingTime)
  {
    this.meetingTime = meetingTime;
  }

  public int getPrice()
  {
    return price;
  }

  public void setPrice(int price)
  {
    this.price = price;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

}
