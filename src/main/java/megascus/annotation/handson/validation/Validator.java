package megascus.annotation.handson.validation;

import java.lang.reflect.Field;
import java.text.MessageFormat;

public class Validator {

  public static void validate(Object object) {
    Field[] fields = object.getClass().getDeclaredFields();
    for (Field field : fields) {
      NotNull notNull = field.getAnnotation(NotNull.class);
      if (notNull != null) {
        try {
          field.setAccessible(true);
          if (field.get(object) == null) {
            throw new NullPointerException(MessageFormat.format(notNull.message(), field.getName()));
          }
        } catch (IllegalAccessException e) {
          // never
        }
      }
    }
  }

}
