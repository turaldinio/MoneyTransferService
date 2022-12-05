package ru.guluev.moneytransferservice.beans;

public class ConfirmOperation {
    private String operationId;
    String code;

    public ConfirmOperation(){

    }

    public ConfirmOperation(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }

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
