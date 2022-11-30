package ru.guluev.moneytransferservice.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.guluev.moneytransferservice.OperationStatus;
import ru.guluev.moneytransferservice.exceptions.ErrorConfirmation;
import ru.guluev.moneytransferservice.writer.LogWriter;
import ru.guluev.moneytransferservice.exceptions.ErrorInputDate;
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
    private AtomicInteger operationId;

    public ResponseEntity<?> transferMoney(@Valid TransferManager transferManager) {
        try {
            logWriter.writeLog(transferManager, operationId.addAndGet(1), OperationStatus.SUCCESSFULLY);
        } catch (Exception e){
            e.printStackTrace();
        }
        logWriter.writeLog(transferManager, operationId.addAndGet(1), OperationStatus.SUCCESSFULLY);
        return new ResponseEntity<>(operationId.get(), HttpStatus.OK);
    }

    public ResponseEntity<?> confirmOperation(Operation operation) {
        if (!operation.getCode().equals("0000")) {
            throw new ErrorConfirmation("Error confirmation");
        }
        return new ResponseEntity<>(operationId.get(), HttpStatus.OK);
    }

}