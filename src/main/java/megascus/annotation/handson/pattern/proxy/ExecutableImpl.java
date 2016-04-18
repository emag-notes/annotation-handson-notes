package megascus.annotation.handson.pattern.proxy;

public class ExecutableImpl implements Executable {

  @Override
  public void execute() {
    System.out.println("execute");
  }

  @Override
  public void execute2() {
    System.out.println("execute2");
  }
}
