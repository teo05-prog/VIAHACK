package model.entities;

public class Activity
{
  private int id;
  private String name;
  private String address;
  private String type;
  private String city;
  private String meetingDate;
  private String meetingTime;
  private String description;

  public Activity(int id, String name, String address, String type, String city,
      String meetingDate, String meetingTime, String description)
  {
    this.id = id;
    this.name = name;
    this.address = address;
    this.type = type;
    this.city = city;
    this.meetingDate = meetingDate;
    this.meetingTime = meetingTime;
    this.description = description;
  }

  public int getId()
  {
    return id;
  }

  public void setId(int id)
  {
    this.id = id;
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

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }


}

