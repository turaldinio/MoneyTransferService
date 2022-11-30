package ru.guluev.moneytransferservice.exceptions;


public class ErrorInputDate extends RuntimeException {
    private String msg;
    private int operationId;

    public ErrorInputDate(String msg) {
        this.msg = msg;
        this.operationId = 0;
    }

    @Override
    public String toString() {
        return "{" +
                "\"message\":" + msg + "," +
                "\n" +
                "\"id\": " + operationId +
                "\n" +
                "}";
    }
}
