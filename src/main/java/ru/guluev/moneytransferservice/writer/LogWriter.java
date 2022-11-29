package ru.guluev.moneytransferservice.writer;

import org.springframework.beans.factory.annotation.Autowired;
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

    public void writeLog(TransferManager transferManager, int operationId) {
        try {
            fileWriter.write(simpleDateFormat.format(Calendar.getInstance().getTime()) + " " +
                    transferManager.toString() + " id=" + operationId + "\n");
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}