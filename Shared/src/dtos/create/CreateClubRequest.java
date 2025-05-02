package dtos.create;

public record CreateClubRequest(String name, String type, String address, String city,
                                int members, String meetingDate, String meetingTime, int price,
                                String description)
{
  @Override
  public String toString(){
    return "CreateClubRequest{" +
        "name='" + name + '\'' +
        ", address='" + address + '\'' +
        "type='" + type + '\'' +
        ", city='" + city + '\'' +
        ", members='" + members + '\'' +
        "meetingDate='" + meetingDate + '\'' +
        ", meetingTime='" + meetingTime + '\'' +
        "price='" + price + '\'' +
        ", description='" + description + '\'' +
        '}';
  }
}
