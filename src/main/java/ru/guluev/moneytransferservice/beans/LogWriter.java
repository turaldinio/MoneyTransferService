package ru.guluev.moneytransferservice.beans;

import org.springframework.beans.factory.annotation.Autowired;
import ru.guluev.moneytransferservice.enums.OperationStatus;
import ru.guluev.moneytransferservice.exceptions.ExceptionResponse;
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

    public void writeLog(TransferManager transferManager, int operationId, OperationStatus operationStatus) {
        try {
            fileWriter.write(simpleDateFormat.format(Calendar.getInstance().getTime()) + " " +
                    transferManager.toString() + " id=" + operationId + " " + operationStatus + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLog(ExceptionResponse response, OperationStatus operationStatus) {
        try {
            fileWriter.write(simpleDateFormat.format(Calendar.getInstance().getTime()) + " " +
                    response.getMessage() + " id=" + response.getId() + " " + operationStatus + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
