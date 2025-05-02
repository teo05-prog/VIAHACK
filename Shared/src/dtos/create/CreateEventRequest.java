package dtos.create;

import java.io.Serializable;

public record CreateEventRequest(String name, String address, String type,
                                 String city, String meetingDate,
                                 String meetingTime, int price,
                                 String description) implements Serializable
{
  @Override
  public String toString(){
    return "CreateEventRequest{" +
        "name='" + name + '\'' +
        ", address='" + address + '\'' +
        "type='" + type + '\'' +
        ", city='" + city + '\'' +
        "meetingDate='" + meetingDate + '\'' +
        ", meetingTime='" + meetingTime + '\'' +
        "price='" + price + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
