package ru.guluev.moneytransferservice.exceptions;

public class ErrorInputDate extends RuntimeException {
    public ErrorInputDate(String msg) {
        super(msg);
    }
}
