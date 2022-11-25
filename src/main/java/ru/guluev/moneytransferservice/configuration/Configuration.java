package ru.guluev.moneytransferservice.configuration;


import org.springframework.context.annotation.Bean;

import java.io.*;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public FileWriter fileWriter(File file) throws IOException {
        return new FileWriter(file);
    }

    @Bean
    public File file() {
        File file = new File("resources/log.txt");
        file.deleteOnExit();
        return file;
    }

}
