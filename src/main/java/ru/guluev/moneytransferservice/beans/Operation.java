package ru.guluev.moneytransferservice.beans;

public class Operation {
    private int operationId;

    public Operation(int operationId) {
        this.operationId = operationId;
    }

    public int getOperationId() {
        return operationId;
    }

    public void setOperationId(int operationId) {
        this.operationId = operationId;
    }
}
