package ru.guluev.moneytransferservice.exceptions;

public abstract class MoneyTransferServiceException extends RuntimeException {
    private ExceptionResponse exceptionResponse;

    public MoneyTransferServiceException(String msg) {
        exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(msg);
    }

    public ExceptionResponse getExceptionResponse() {
        return exceptionResponse;
    }
}
