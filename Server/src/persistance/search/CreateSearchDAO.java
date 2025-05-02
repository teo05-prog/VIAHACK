package persistance.search;

import model.entities.Activity;
import model.entities.Club;
import model.entities.Event;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CreateSearchDAO implements SearchDAO {
  private static CreateSearchDAO instance;

  private CreateSearchDAO() throws SQLException {
    DriverManager.registerDriver(new org.postgresql.Driver());
  }

  public static synchronized CreateSearchDAO getInstance() throws SQLException {
    if (instance == null) {
      instance = new CreateSearchDAO();
    }
    return instance;
  }

  @Override
  public List<Activity> search(String city, String type) {
    List<Activity> results = new ArrayList<>();
    try (Connection connection = getConnection()) {
      StringBuilder query = new StringBuilder(
          "SELECT * FROM club WHERE 1=1 " +
              "UNION ALL " +
              "SELECT * FROM event WHERE 1=1 "
      );
      List<Object> params = new ArrayList<>();

      if (city != null && !city.isEmpty()) {
        query.append("AND city = ? ");
        params.add(city);
      }
      if (type != null && !type.isEmpty()) {
        query.append("AND type = ? ");
        params.add(type);
      }

      PreparedStatement statement = connection.prepareStatement(query.toString());
      for (int i = 0; i < params.size(); i++) {
        statement.setObject(i + 1, params.get(i));
      }

      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        if (resultSet.getString("table_name").equals("club")) {
          results.add(new Club(
              resultSet.getInt("id"),
              resultSet.getString("name"),
              resultSet.getString("type"),
              resultSet.getString("address"),
              resultSet.getString("city"),
              resultSet.getString("description"),
              resultSet.getString("meeting_date"),
              resultSet.getString("meeting_time"),
              resultSet.getInt("members")
          ));
        } else {
          results.add(new Event(
              resultSet.getInt("id"),
              resultSet.getString("name"),
              resultSet.getString("type"),
              resultSet.getString("address"),
              resultSet.getString("city"),
              resultSet.getString("meeting_date"),
              resultSet.getString("meeting_time"),
              resultSet.getInt("price"),
              resultSet.getString("description")
          ));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return results;
  }

  private static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(
        "jdbc:postgresql://localhost:5432/viahack?currentSchema=jdbc",
        "postgres",
        "1412"
    );
  }
}