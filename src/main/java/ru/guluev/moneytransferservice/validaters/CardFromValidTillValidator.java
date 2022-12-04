package ru.guluev.moneytransferservice.validaters;

import ru.guluev.moneytransferservice.annotation.CardFromValidTill;
import ru.guluev.moneytransferservice.exceptions.ErrorInputDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardFromValidTillValidator implements ConstraintValidator<CardFromValidTill, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
        simpleDateFormat.setLenient(false);

        Pattern monthAndYearPattern = Pattern.compile("\\d{2}");
        Matcher start = monthAndYearPattern.matcher(s);

        try {
            if (!start.lookingAt()) {
                throw new ErrorInputDate(String.format("the month (%s) field must contain 2 digits", s));
            }

            if (!s.matches("^\\d{2}[/]{1}\\d{2}")) {
                throw new ErrorInputDate(String.format("The expiration date of the card is incorrectly specified (%s).Enter the date in the format **/**", s));
            }
            Date date = simpleDateFormat.parse(s);
            if (date.before(new Date())) {
                throw new ErrorInputDate(String.format("The card has expired! (%s)", s));
            }
        } catch (ParseException e) {
            throw new ErrorInputDate("The expiration date of the card is incorrectly specified.Enter the date in the format **/**");
        }
        return true;
    }
}
