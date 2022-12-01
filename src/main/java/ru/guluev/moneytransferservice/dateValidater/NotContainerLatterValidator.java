package ru.guluev.moneytransferservice.dateValidater;

import ru.guluev.moneytransferservice.annotation.NotContainLatter;
import ru.guluev.moneytransferservice.exceptions.ErrorInputDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotContainerLatterValidator implements ConstraintValidator<NotContainLatter, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (!s.matches("[0-9]+")) {
            throw new ErrorInputDate("The card data cannot contain letters " + s);
        }
        return true;
    }
}
