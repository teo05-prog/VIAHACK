package services.create;

import dtos.create.CreateActivityRequest;
import dtos.create.CreateClubRequest;
import model.entities.Club;
import persistance.create.CreateDAO;

import java.sql.SQLException;

public class CreateServiceImpl implements CreateService
{
  private final CreateDAO createRepo;
  public CreateServiceImpl(CreateDAO createDao)
  {
    createRepo = createDao;
  }
  public void create(CreateActivityRequest request) throws SQLException
  {

  }

}
