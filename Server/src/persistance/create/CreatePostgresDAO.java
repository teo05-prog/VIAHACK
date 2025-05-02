package persistance.create;

import model.entities.Club;
import model.entities.Event;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CreatePostgresDAO implements CreateDAO
{
  private static CreatePostgresDAO instance;

  private CreatePostgresDAO() throws SQLException
  {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized CreatePostgresDAO getInstance() throws SQLException
  {
    if (instance == null)
    {
      instance = new CreatePostgresDAO();
    }
    return instance;
  }

  @Override public Club createClub(String name, String type, String address, String city, int members,
      String meetingDate, String meetingTime, String description)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO club(name, type, address, city, members, meeting_date, meeting_time, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);",
          PreparedStatement.RETURN_GENERATED_KEYS);
      statement.setString(1, name);
      statement.setString(2, type);
      statement.setString(3, address);
      statement.setString(4, city);
      statement.setInt(5, members);
      statement.setString(6, meetingDate);
      statement.setString(7, meetingTime);
      statement.setString(9, description);
      statement.executeUpdate();
      statement.getGeneratedKeys();
      ResultSet keys = statement.getGeneratedKeys();
      if (keys.next())
      {
        return new Club(keys.getInt(1), name, address, type, city, meetingDate, meetingTime, description, members);
      }
      else
      {
        throw new SQLException("No keys generated");
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  private static Connection getConnection() throws SQLException
  {
    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/viahack?currentSchema=jdbc", "postgres",
        "1412");
  }

  @Override public Club readByClubId(int id)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM club WHERE id = ?;");
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String name = resultSet.getString("name");
        String type = resultSet.getString("type");
        String address = resultSet.getString("address");
        String city = resultSet.getString("city");
        String meetingDate = resultSet.getString("meeting_date");
        String meetingTime = resultSet.getString("meeting_time");
        String description = resultSet.getString("description");
        int members = resultSet.getInt("members");
        return new Club(id, name, address, type, city, meetingDate, meetingTime, description, members);
      }
      else
      {
        throw new SQLException("No club found with id: " + id);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public Event createEvent(String name, String type, String address, String city, String meetingDate,
      String meetingTime, int price, String description)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO event(name, type, address, city, price, meeting_date, meeting_time, description) VALUES (?, ?, ?, ?, ?, ?, ?, ?);",
          PreparedStatement.RETURN_GENERATED_KEYS);
      statement.setString(1, name);
      statement.setString(2, type);
      statement.setString(3, address);
      statement.setString(4, city);
      statement.setInt(5, price);
      statement.setString(6, meetingDate);
      statement.setString(7, meetingTime);
      statement.setString(8, description);
      statement.executeUpdate();
      ResultSet keys = statement.getGeneratedKeys();
      if (keys.next())
      {
        return new Event(keys.getInt(1), name, type, address, city, meetingDate, meetingTime, price, description);
      }
      else
      {
        throw new SQLException("No keys generated");
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public Event readByEventId(int id)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM event WHERE id = ?;");
      statement.setInt(1, id);
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next())
      {
        String name = resultSet.getString("name");
        String type = resultSet.getString("type");
        String address = resultSet.getString("address");
        String city = resultSet.getString("city");
        String meetingDate = resultSet.getString("meeting_date");
        String meetingTime = resultSet.getString("meeting_time");
        int price = resultSet.getInt("price");
        String description = resultSet.getString("description");
        return new Event(id, name, type, address, city, meetingDate, meetingTime, price, description);
      }
      else
      {
        throw new SQLException("No event found with id: " + id);
      }
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public List<Club> readByName(String searchString)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM club WHERE name = ?;");
      statement.setString(1, "%" + searchString + "%");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Club> result = new ArrayList<>();
      while (resultSet.next())
      {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String type = resultSet.getString("type");
        String address = resultSet.getString("address");
        String city = resultSet.getString("city");
        String meetingDate = resultSet.getString("meeting_date");
        String meetingTime = resultSet.getString("meeting_time");
        String description = resultSet.getString("description");
        int members = resultSet.getInt("members");
        Club club = new Club(id, name, address, type, city, meetingDate, meetingTime, description, members);
        result.add(club);
      }
      return result;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public List<Event> readByEventName(String name)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("SELECT * FROM event WHERE name = ?;");
      statement.setString(1, "%" + name + "%");
      ResultSet resultSet = statement.executeQuery();
      ArrayList<Event> result = new ArrayList<>();
      while (resultSet.next())
      {
        int id = resultSet.getInt("id");
        String type = resultSet.getString("type");
        String address = resultSet.getString("address");
        String city = resultSet.getString("city");
        String meetingDate = resultSet.getString("meeting_date");
        String meetingTime = resultSet.getString("meeting_time");
        int price = resultSet.getInt("price");
        String description = resultSet.getString("description");
        Event event = new Event(id, name, type, address, city, meetingDate, meetingTime, price, description);
        result.add(event);
      }
      return result;
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void updateClub(Club club)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "UPDATE club SET name = ?, type = ?, address = ?, city = ?, members = ?, meeting_date = ?, meeting_time = ?, description = ? WHERE id = ?;");
      statement.setString(1, club.getName());
      statement.setString(2, club.getType());
      statement.setString(3, club.getAddress());
      statement.setString(4, club.getCity());
      statement.setInt(5, club.getMembers());
      statement.setString(6, club.getMeetingDate());
      statement.setString(7, club.getMeetingTime());
      statement.setString(8, club.getDescription());
      statement.setInt(9, club.getId());
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void updateEvent(Event event)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement(
          "UPDATE event SET name = ?, type = ?, address = ?, city = ?, price = ?, meeting_date = ?, meeting_time = ?, description = ? WHERE id = ?;");
      statement.setString(1, event.getName());
      statement.setString(2, event.getType());
      statement.setString(3, event.getAddress());
      statement.setString(4, event.getCity());
      statement.setInt(5, event.getPrice());
      statement.setString(6, event.getMeetingDate());
      statement.setString(7, event.getMeetingTime());
      statement.setString(8, event.getDescription());
      statement.setInt(9, event.getId());
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void deleteClub(Club club)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("DELETE FROM club WHERE id = ?;");
      statement.setInt(1, club.getId());
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void deleteEvent(Event event)
  {
    try (Connection connection = getConnection())
    {
      PreparedStatement statement = connection.prepareStatement("DELETE FROM event WHERE id = ?;");
      statement.setInt(1, event.getId());
      statement.executeUpdate();
    }
    catch (SQLException e)
    {
      e.printStackTrace();
    }
  }
}
