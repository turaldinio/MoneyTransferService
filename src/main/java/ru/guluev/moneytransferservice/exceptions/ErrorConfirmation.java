package ru.guluev.moneytransferservice.exceptions;

public class ErrorConfirmation extends RuntimeException {
    public ErrorConfirmation(String msg) {
        super(msg);
    }
}
