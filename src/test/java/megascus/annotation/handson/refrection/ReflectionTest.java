package megascus.annotation.handson.refrection;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

public class ReflectionTest {

  @Test
  public void test() throws Exception {
    Class<?> clazz = Class.forName("megascus.annotation.handson.refrection.TestTarget");
    Constructor<?> constructor = clazz.getConstructor();
    Object instance = constructor.newInstance();
//    instance = clazz.newInstance(); // you can create an instance from Class if default constructor exists

    Method staticMethod = instance.getClass().getMethod("staticMethod1", String.class);
    assertThat(staticMethod.invoke(null, "文字列")).isEqualTo("文字列");

    Method instanceMethod = instance.getClass().getMethod("method1", String[].class);
    assertThat(instanceMethod.invoke(instance, (Object) new String[]{"文字列1", "文字列2"})).isEqualTo("文字列1");
  }

}
