package com.app.validators;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = EmailIdValidator.class)
@Documented
public @interface EmailId {

	String message() default "Invalid email";

	String regExp();

	// String value();

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
