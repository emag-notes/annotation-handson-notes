package megascus.annotation.handson.refrection;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NoReflectionTest {

  @Test
  public void test() throws Exception {
    TestTarget instance = new TestTarget();
    assertThat(TestTarget.staticMethod1("文字列")).isEqualTo("文字列");
    assertThat(instance.method1("文字列1", "文字列2")).isEqualTo("文字列1");
  }

}