package ru.guluev.moneytransferservice.exceptions;

public class ErrorTransfer extends RuntimeException {
    private ExceptionResponse exceptionResponse;

    public ErrorTransfer(String msg) {
        super(msg);
        exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(msg);
    }

    public ExceptionResponse getExceptionResponse() {
        return exceptionResponse;
    }
}
