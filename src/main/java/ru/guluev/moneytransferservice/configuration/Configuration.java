package ru.guluev.moneytransferservice.configuration;


import org.springframework.context.annotation.Bean;
import ru.guluev.moneytransferservice.writer.LogWriter;

import java.io.*;
import java.nio.file.Files;
import java.util.concurrent.atomic.AtomicInteger;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public FileWriter fileWriter(File file) throws IOException {
        return new FileWriter(file);
    }

    @Bean
    public File file() {
        File file = new File("src/main/resources/log.txt");
        try {
            if (Files.deleteIfExists(file.toPath())) {
                Files.createFile(file.toPath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Bean
    public AtomicInteger atomicInteger() {
        return new AtomicInteger(1);
    }

    @Bean
    public LogWriter logWriter() {
        return new LogWriter();
    }
}
