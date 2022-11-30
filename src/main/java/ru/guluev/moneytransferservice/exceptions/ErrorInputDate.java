package ru.guluev.moneytransferservice.exceptions;

public class ErrorInputDate extends RuntimeException {
    private String msg;
    private int operationId;

    public ErrorInputDate(String msg, int operationId) {
        this.msg = msg;
        this.operationId = operationId;
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
