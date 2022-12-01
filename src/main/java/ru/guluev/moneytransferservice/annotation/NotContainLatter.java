package ru.guluev.moneytransferservice.annotation;

import ru.guluev.moneytransferservice.dateValidater.CardNumberValidator;
import ru.guluev.moneytransferservice.dateValidater.NotContainerLatterValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = NotContainerLatterValidator.class)
public @interface NotContainLatter {
    String message() default "{NotContainerLatter.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

