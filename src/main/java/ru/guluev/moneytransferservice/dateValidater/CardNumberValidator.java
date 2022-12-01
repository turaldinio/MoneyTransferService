package ru.guluev.moneytransferservice.dateValidater;

import ru.guluev.moneytransferservice.annotation.CardNumber;
import ru.guluev.moneytransferservice.exceptions.ErrorInputDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CardNumberValidator implements ConstraintValidator<CardNumber, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (!s.matches("\\d{16}")) {
            throw new ErrorInputDate("The card number must consist of 16 digits "+s);
        }
        return true;
    }
}
