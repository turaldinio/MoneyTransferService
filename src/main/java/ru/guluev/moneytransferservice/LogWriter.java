package ru.guluev.moneytransferservice;

import ru.guluev.moneytransferservice.model.TransferManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class LogWriter {

    private FileWriter fileWriter;

    public void writeLog(TransferManager transferManager) {
        try {
            fileWriter.write(Calendar.getInstance().getTime() + " " + transferManager.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
