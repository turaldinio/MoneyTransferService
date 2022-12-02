package ru.guluev.moneytransferservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.guluev.moneytransferservice.OperationStatus;
import ru.guluev.moneytransferservice.beans.LogWriter;
import ru.guluev.moneytransferservice.exceptions.ExceptionResponse;
import ru.guluev.moneytransferservice.model.TransferManager;

@Service
public class LoggerService {
    @Autowired
    private LogWriter logWriter;

    public void writeLog(TransferManager transferManager, String operationId, OperationStatus operationStatus) {
        logWriter.writeLog(transferManager, operationId, operationStatus);
    }

    public void writeLog(ExceptionResponse response, OperationStatus operationStatus) {
        logWriter.writeLog(response, operationStatus);
    }
}
