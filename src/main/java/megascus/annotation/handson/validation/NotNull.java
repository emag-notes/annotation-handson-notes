package megascus.annotation.handson.validation;

import java.lang.annotation.*;

@Target(value = {ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotNull {
  public String message() default "{0} の値が null です。";
}
