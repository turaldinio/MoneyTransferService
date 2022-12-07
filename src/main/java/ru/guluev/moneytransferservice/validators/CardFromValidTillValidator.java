package ru.guluev.moneytransferservice.validators;

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
        simpleDateFormat.setLenient(false);

        String[] dateArray = s.split("/");
        if (dateArray.length != 2) {
            throw new ErrorInputDate(String.format("The expiration date of the card is incorrectly specified (%s).Enter the date in the format **/**", s));
        }

        try {
            if (!dateArray[0].matches("\\d{2}")) {
                throw new ErrorInputDate(String.format("the month (%s) field must contain 2 digits [01-12]", dateArray[0]));
            }
            if (!dateArray[1].matches("\\d{2}")) {
                throw new ErrorInputDate(String.format("the year (%s) field must contain 2 digits", dateArray[1]));
            }
            Date date = simpleDateFormat.parse(s);
            if (date.before(new Date())) {
                throw new ErrorInputDate(String.format("The card has expired! (%s)", s));
            }
        } catch (ParseException e) {
            throw new ErrorInputDate(String.format("the month field (%s) should be between 01-12 ",dateArray[0]));
        }
        return true;
    }
}
