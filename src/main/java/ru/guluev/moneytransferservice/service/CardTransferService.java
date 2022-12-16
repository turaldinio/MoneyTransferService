package ru.guluev.moneytransferservice.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.guluev.moneytransferservice.beans.AmountManager;
import ru.guluev.moneytransferservice.beans.Operation;
import ru.guluev.moneytransferservice.enums.OperationStatus;
import ru.guluev.moneytransferservice.exceptions.ErrorConfirmation;
import ru.guluev.moneytransferservice.beans.ConfirmOperation;
import ru.guluev.moneytransferservice.exceptions.ErrorTransfer;
import ru.guluev.moneytransferservice.model.TransferManager;
import ru.guluev.moneytransferservice.repository.OperationRepository;

import javax.validation.Valid;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Validated
public class CardTransferService {
    private final LoggerService loggerService;

    private final OperationRepository operationRepository;

    private AtomicInteger atomicInteger = new AtomicInteger(0);


    public CardTransferService(LoggerService loggerService, OperationRepository operationRepository) {
        this.loggerService = loggerService;
        this.operationRepository = operationRepository;
    }

    public Operation transferMoney(@Valid TransferManager transferManager, @Valid AmountManager amountManager) {
        if (transferManager.getCardFromNumber().equals(transferManager.getCardToNumber())) {
            throw new ErrorTransfer("you cannot transfer money to the same card");
        }
        Operation operation = new Operation(atomicInteger.addAndGet(1));

        operationRepository.addNewOperation(operation);

        loggerService.writeLog(transferManager, operation.getOperationId(), OperationStatus.SUCCESSFULLY);

        return operation;
    }

    public Operation confirmOperation(ConfirmOperation confirmOperation) {
        if (!confirmOperation.getCode().equals("0000")) {
            throw new ErrorConfirmation("Error confirm operation");
        }
        return operationRepository.getValueByKey(confirmOperation.getOperationId());

    }

}