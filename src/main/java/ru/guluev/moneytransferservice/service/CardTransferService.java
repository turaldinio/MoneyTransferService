package ru.guluev.moneytransferservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.guluev.moneytransferservice.beans.AmountManager;
import ru.guluev.moneytransferservice.beans.Operation;
import ru.guluev.moneytransferservice.enums.OperationStatus;
import ru.guluev.moneytransferservice.exceptions.ErrorConfirmation;
import ru.guluev.moneytransferservice.beans.ConfirmOperation;
import ru.guluev.moneytransferservice.exceptions.ErrorTransfer;
import ru.guluev.moneytransferservice.model.TransferManager;

import javax.validation.Valid;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Validated
public class CardTransferService {
    @Autowired
    private LoggerService loggerService;

    @Autowired
    private AtomicInteger atomicInteger;

    private Operation operation;

    public Operation transferMoney(@Valid TransferManager transferManager, @Valid AmountManager amountManager) {
        if (transferManager.getCardFromNumber().equals(transferManager.getCardToNumber())) {
            throw new ErrorTransfer("you cannot transfer money to the same card");
        }
        operation.setOperationId(String.valueOf(atomicInteger.addAndGet(1)));
        loggerService.writeLog(transferManager, operation.getOperationId(), OperationStatus.SUCCESSFULLY);

        return operation;
    }

    public Operation confirmOperation(ConfirmOperation confirmOperation) {
        if (!confirmOperation.getCode().equals("0000")) {
            throw new ErrorConfirmation("Error confirm operation");
        }
        return operation;
    }

}