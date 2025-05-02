package viewModel;

import networking.create.CreateClient;

public class CreateAnActivityVM
{
  private final CreateClient createService;

  public CreateAnActivityVM(CreateClient createService)
  {
    this.createService = createService;
  }
}
