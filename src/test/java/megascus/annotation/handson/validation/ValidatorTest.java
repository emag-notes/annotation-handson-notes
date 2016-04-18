package megascus.annotation.handson.validation;

import org.junit.Test;

public class ValidatorTest {

  @Test(expected = NullPointerException.class)
  public void test_invalid() throws Exception {
    Validator.validate(new Book());
  }

  @Test
  public void test_valid() throws Exception {
    Book book = new Book();
    book.setId(1L);
    book.setIsbn("isbn");
    Validator.validate(book);
  }
}