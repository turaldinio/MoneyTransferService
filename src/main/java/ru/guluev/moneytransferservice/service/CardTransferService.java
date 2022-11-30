package ru.guluev.moneytransferservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.guluev.moneytransferservice.OperationStatus;
import ru.guluev.moneytransferservice.exceptions.ErrorConfirmation;
import ru.guluev.moneytransferservice.exceptions.ErrorInputDate;
import ru.guluev.moneytransferservice.writer.LogWriter;
import ru.guluev.moneytransferservice.model.Operation;
import ru.guluev.moneytransferservice.model.TransferManager;

import javax.validation.Valid;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Validated
public class CardTransferService {
    @Autowired
    private LogWriter logWriter;

    @Autowired
    private Operation operation;

    @Autowired
    AtomicInteger atomicInteger;

    public Operation transferMoney(@Valid TransferManager transferManager) {
        operation.setOperationId(String.valueOf(atomicInteger.addAndGet(1)));
        logWriter.writeLog(transferManager, operation.getOperationId(), OperationStatus.SUCCESSFULLY);

        return operation;
    }

    public Operation confirmOperation(Operation operation) {
        if (!operation.getCode().equals("0000")) {
            throw new ErrorInputDate("Error confirm operation");
        }
        return operation;
    }

}