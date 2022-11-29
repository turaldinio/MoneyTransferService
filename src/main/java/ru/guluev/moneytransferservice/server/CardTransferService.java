package ru.guluev.moneytransferservice.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.guluev.moneytransferservice.LogWriter;
import ru.guluev.moneytransferservice.exceptions.ErrorInputDate;
import ru.guluev.moneytransferservice.model.Operation;
import ru.guluev.moneytransferservice.model.TransferManager;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CartTransferService {
    @Autowired
    private LogWriter logWriter;
    @Autowired
    private AtomicInteger operationId;

    public ResponseEntity<?> transferMoney(TransferManager transferManager) {
        logWriter.writeLog(transferManager);
        return new ResponseEntity<>(operationId.getAndAdd(1), HttpStatus.OK);
    }

    public ResponseEntity<?> confirmOperation(Operation operation) {
        if (!operation.getCode().equals("0000")) {
            throw new ErrorInputDate("Error input date");
        }
        return new ResponseEntity<>(operationId, HttpStatus.OK);
    }

}