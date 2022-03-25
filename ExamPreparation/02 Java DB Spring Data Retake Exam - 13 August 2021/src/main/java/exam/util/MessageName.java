package exam.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MessageName {

    /**
     *
     * @return entity name assigned to the Dto
     */
    String name() default "##default";
}
