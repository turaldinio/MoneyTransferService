package ru.guluev.moneytransferservice.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Operation {
    private String operationId;
    String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String printOperationId() {
        return "{" +
                "\n\"operationId\":" + "\"" + operationId + "\"" + "\n}";
    }
}
