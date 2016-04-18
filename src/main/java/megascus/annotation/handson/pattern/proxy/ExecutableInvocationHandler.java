package megascus.annotation.handson.pattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ExecutableInvocationHandler implements InvocationHandler {

  Executable e;

  public ExecutableInvocationHandler(Executable e) {
    this.e = e;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println(String.format("### %s start", method.getName()));
    Object invoke = method.invoke(e, args);
    System.out.println(String.format("### %s end", method.getName()));
    return invoke;
  }

}
