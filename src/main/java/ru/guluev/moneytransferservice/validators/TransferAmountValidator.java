package ru.guluev.moneytransferservice.validators;

import ru.guluev.moneytransferservice.annotation.TransferAmount;
import ru.guluev.moneytransferservice.exceptions.ErrorInputDate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TransferAmountValidator implements ConstraintValidator<TransferAmount, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        try {
            int transferAmount = Integer.parseInt(s);
            if (transferAmount <= 0) {
                throw new ErrorInputDate("the transfer amount must be strictly greater than zero");
            }
        } catch (NumberFormatException e) {
            throw new ErrorInputDate("the transfer amount is specified incorrectly");
        }
        return true;
    }
}
