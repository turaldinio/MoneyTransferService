package ru.guluev.moneytransferservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import ru.guluev.moneytransferservice.model.TransferManager;

@RestController
public class Controller {

    @PostMapping("/transfer")
    @ResponseStatus(HttpStatus.OK)
    public void transfer(@RequestBody TransferManager transferManager) {

    }
}
