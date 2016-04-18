package megascus.annotation.handson.pattern.proxy;

import org.junit.Test;

import java.lang.reflect.Proxy;

public class ProxyTest {

  @Test
  public void test() throws Exception {
    Executable e = new ExecutableImpl();
    e.execute();
  }

  @Test
  public void test_proxy() throws Exception {
    Executable e1 = new ExecutableImpl();
    Executable e2 = new ExecutableProxy(e1);
    e2.execute();
  }

  @Test
  public void test_invocation_handler() throws Exception {
    Executable e1 = new ExecutableImpl();
    Executable e2 = (Executable) Proxy.newProxyInstance(getClass().getClassLoader(), new Class<?>[]{Executable.class}, new ExecutableInvocationHandler(e1));
    e2.execute();
    e2.execute2();
  }

}