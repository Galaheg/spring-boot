package Validate;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD}) // where can we apply this annotation: class and fields
@Retention(RetentionPolicy.RUNTIME) // we use this at runtime
public @interface CourseCode {

    public String value() default "HEMRE";

    public String message() default "must start with HEMRE";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};

}
