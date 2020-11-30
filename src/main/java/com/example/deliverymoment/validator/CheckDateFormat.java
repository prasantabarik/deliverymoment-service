package com.example.deliverymoment.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateFormatValidator.class)
@Documented
public @interface CheckDateFormat {
	
	String message() default "{constraintValidatorContext.CheckDateFormat.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
