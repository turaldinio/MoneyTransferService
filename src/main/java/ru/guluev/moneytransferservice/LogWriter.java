package ru.guluev.moneytransferservice;

import org.springframework.beans.factory.annotation.Autowired;
import ru.guluev.moneytransferservice.model.TransferManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class LogWriter {
    @Autowired
    private FileWriter fileWriter;

    public void writeLog(TransferManager transferManager) {
        try {
            fileWriter.write(Calendar.getInstance().getTime() + " " + transferManager.toString());
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
