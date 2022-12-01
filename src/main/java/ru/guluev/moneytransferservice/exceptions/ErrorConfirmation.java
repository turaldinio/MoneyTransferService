package ru.guluev.moneytransferservice.exceptions;

public class ErrorConfirmation extends RuntimeException {
    private ExceptionResponse exceptionResponse;

    public ErrorConfirmation(String msg) {
        exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(msg);
    }

    public ExceptionResponse getExceptionResponse() {
        return exceptionResponse;
    }
}
