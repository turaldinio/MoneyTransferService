package ru.guluev.moneytransferservice.beans;

import org.springframework.beans.factory.annotation.Autowired;
import ru.guluev.moneytransferservice.OperationStatus;
import ru.guluev.moneytransferservice.model.TransferManager;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class LogWriter {
    @Autowired
    private FileWriter fileWriter;
    @Autowired
    private SimpleDateFormat simpleDateFormat;

    public void writeLog(TransferManager transferManager, String operationId, OperationStatus operationStatus) {
        try {
            fileWriter.write(simpleDateFormat.format(Calendar.getInstance().getTime()) + " " +
                    transferManager.toString() + " id=" + operationId + " " + operationStatus + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
