package ru.guluev.moneytransferservice.exceptions;


public class ErrorInputDate extends RuntimeException {
    private ExceptionResponse exceptionResponse;

    public ErrorInputDate(String msg) {
        super(msg);
        exceptionResponse = new ExceptionResponse();
        exceptionResponse.setMessage(msg);
    }

    public ExceptionResponse getExceptionResponse() {
        return exceptionResponse;
    }
}
