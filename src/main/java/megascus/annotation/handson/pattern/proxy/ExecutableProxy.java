package megascus.annotation.handson.pattern.proxy;

public class ExecutableProxy implements Executable {

  private final Executable e;

  public ExecutableProxy(Executable e) {
    this.e = e;
  }

  @Override
  public void execute() {
    System.out.println("execute start");
    e.execute();
    System.out.println("execute end");
  }

  @Override
  public void execute2() {
    System.out.println("execute2 start");
    e.execute();
    System.out.println("execute2 end");
  }
}
