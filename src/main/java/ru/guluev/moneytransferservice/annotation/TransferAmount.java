package ru.guluev.moneytransferservice.annotation;


import ru.guluev.moneytransferservice.validaters.TransferAmountValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = TransferAmountValidator.class)
public @interface TransferAmount {
    String message() default "{TransferAmount.invalid}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
