package ru.guluev.moneytransferservice;

import ru.guluev.moneytransferservice.annotation.CardFromValidTill;
import ru.guluev.moneytransferservice.exceptions.ErrorInputDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CardFromValidTillValidator implements ConstraintValidator<CardFromValidTill, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
        try {
            Date date = simpleDateFormat.parse(s);
            if (date.before(new Date())) {
                throw new ErrorInputDate("the expiration date of the card is incorrectly specified");
            }
        } catch (ParseException e) {
            throw new ErrorInputDate("the expiration date of the card is incorrectly specified");
        }
        return true;
    }
}
