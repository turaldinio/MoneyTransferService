package ru.guluev.moneytransferservice.exceptions;


public class ErrorInputDate extends MoneyTransferServiceException{
    public ErrorInputDate(String msg) {
        super(msg);
    }
}
