package ru.guluev.moneytransferservice.annotation;

import ru.guluev.moneytransferservice.beans.CardCVVValidator;

import javax.validation.Constraint;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = CardCVVValidator.class)
public @interface CardCVV {
}
