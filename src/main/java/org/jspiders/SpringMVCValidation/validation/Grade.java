package org.jspiders.SpringMVCValidation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GradeValidator.class)
public @interface Grade {
    String message() default "INVALID DATA";
    Class<?>[] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
