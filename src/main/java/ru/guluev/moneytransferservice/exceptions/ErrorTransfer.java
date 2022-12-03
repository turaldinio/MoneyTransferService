package ru.guluev.moneytransferservice.exceptions;

public class ErrorTransfer extends MoneyTransferServiceException {
    public ErrorTransfer(String msg) {
        super(msg);
    }
}

