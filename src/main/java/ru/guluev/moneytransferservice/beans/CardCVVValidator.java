package ru.guluev.moneytransferservice.beans;

import ru.guluev.moneytransferservice.annotation.CardCVV;
import ru.guluev.moneytransferservice.exceptions.ErrorInputDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardCVVValidator implements ConstraintValidator<CardCVV, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (!s.matches("\\d{3}")) {
            throw new ErrorInputDate("The cvv must consist of 3 digits");
        }
        return true;
    }
}


