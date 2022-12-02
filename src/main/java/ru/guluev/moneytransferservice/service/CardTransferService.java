package ru.guluev.moneytransferservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.guluev.moneytransferservice.beans.Operation;
import ru.guluev.moneytransferservice.OperationStatus;
import ru.guluev.moneytransferservice.exceptions.ErrorConfirmation;
import ru.guluev.moneytransferservice.beans.LogWriter;
import ru.guluev.moneytransferservice.beans.ConfirmOperation;
import ru.guluev.moneytransferservice.exceptions.ErrorTransfer;
import ru.guluev.moneytransferservice.model.TransferManager;

import javax.validation.Valid;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Validated
public class CardTransferService {
    @Autowired
    private LogWriter logWriter;

    @Autowired
    AtomicInteger atomicInteger;

    @Autowired
    Operation operation;

    public Operation transferMoney(@Valid TransferManager transferManager) {
        if (transferManager == null || logWriter == null || atomicInteger == null || operation == null) {
            throw new ErrorTransfer("transfer error");
        }
        operation.setOperationId(String.valueOf(atomicInteger.addAndGet(1)));
        logWriter.writeLog(transferManager, operation.getOperationId(), OperationStatus.SUCCESSFULLY);

        return operation;
    }

    public Operation confirmOperation(ConfirmOperation confirmOperation) {
        if (!confirmOperation.getCode().equals("0000")) {
            throw new ErrorConfirmation("Error confirm operation");
        }
        return operation;
    }

}