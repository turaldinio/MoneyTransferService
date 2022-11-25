package ru.guluev.moneytransferservice.server;

import org.springframework.stereotype.Service;
import ru.guluev.moneytransferservice.LogWriter;
import ru.guluev.moneytransferservice.exceptions.ErrorConfirmation;
import ru.guluev.moneytransferservice.model.TransferManager;

@Service
public class CartTransferService {
    private LogWriter logWriter;

    public void transferMoney(TransferManager transferManager) {
        try {

        } catch (ErrorConfirmation errorConfirmation) {

        }
        logWriter.writeLog(transferManager);
    }


}
