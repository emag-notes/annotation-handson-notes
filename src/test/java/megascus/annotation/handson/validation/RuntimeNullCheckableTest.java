package megascus.annotation.handson.validation;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;

public class RuntimeNullCheckableTest {

  @Test
  public void test_with_NotNull() throws Exception {
    RuntimeNullCheckable runtimeNullCheckable = new RuntimeNullCheckable() {
      @Override
      public void execute(@NotNull Object arg) {
        System.out.println(arg.toString());
      }
    };
    execute(runtimeNullCheckable, null);
  }

  @Test(expected = NullPointerException.class)
  public void test_without_NotNull() throws Exception {
    RuntimeNullCheckable runtimeNullCheckable = new RuntimeNullCheckable() {
      @Override
      public void execute(Object arg) {
        System.out.println(arg.toString());
      }
    };
    execute(runtimeNullCheckable, null);
  }

  private void execute(RuntimeNullCheckable runtimeNullCheckable, Object arg) {
    try {
      NotNull notNull = runtimeNullCheckable.getClass().getMethod("execute", Object.class).getParameters()[0].getAnnotation(NotNull.class);
      if (notNull != null && arg == null) {
        return; // no-op
      }
    } catch (NoSuchMethodException e) {
      // never
    }
    runtimeNullCheckable.execute(arg);
  }

  ///////////////////////////////////////////////////////

  @Test
  public void test_proxy() throws Exception {
    RuntimeNullCheckable runtimeNullCheckable = getInstance(new RuntimeNullCheckable() {
      @Override
      public void execute(@NotNull Object arg) {
        System.out.println(arg.toString());
      }
    });
    runtimeNullCheckable.execute(null);
  }

  private static RuntimeNullCheckable getInstance(RuntimeNullCheckable o) {
    return (RuntimeNullCheckable) Proxy.newProxyInstance(RuntimeNullCheckableTest.class.getClassLoader(), new Class[]{RuntimeNullCheckable.class}, new RuntimeNullCheckableInvocationHandler(o));
  }
}

class RuntimeNullCheckableInvocationHandler implements InvocationHandler {

  RuntimeNullCheckable e;

  public RuntimeNullCheckableInvocationHandler(RuntimeNullCheckable e) {
    this.e = e;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    int i = 0;
    for (Parameter param : e.getClass().getMethod(method.getName(), method.getParameterTypes()).getParameters()) {
      NotNull notNull = param.getAnnotation(NotNull.class);
      if (notNull != null && args[i++] == null) {
        return null;
      }
    }
    return method.invoke(e, args);
  }

}