package ru.guluev.moneytransferservice.exceptions;

public class ErrorConfirmation extends MoneyTransferServiceException {
    public ErrorConfirmation(String msg) {
        super(msg);
    }
}
