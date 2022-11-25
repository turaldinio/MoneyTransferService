package ru.guluev.moneytransferservice.exceptions;

public class ErrorTransfer extends RuntimeException {
    public ErrorTransfer(String msg) {
        super(msg);
    }
}
