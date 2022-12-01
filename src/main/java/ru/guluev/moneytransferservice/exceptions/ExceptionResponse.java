package ru.guluev.moneytransferservice.exceptions;

public class ExceptionResponse {
    private String message;
    private int id = 0;

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
