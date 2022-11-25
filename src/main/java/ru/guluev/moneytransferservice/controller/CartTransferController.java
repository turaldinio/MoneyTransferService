package ru.guluev.moneytransferservice.controller;

import org.springframework.web.bind.annotation.*;
import ru.guluev.moneytransferservice.model.Operation;
import ru.guluev.moneytransferservice.model.TransferManager;
import ru.guluev.moneytransferservice.server.CartTransferService;

@RestController
public class CartTransferController {
    private CartTransferService cartTransferService;

    @CrossOrigin
    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferManager transferManager) {
        cartTransferService.transferMoney(transferManager);

    }

    @CrossOrigin
    @PostMapping("/confirmOperation")
    public String confirmOperation(@RequestBody Operation operation) {
        return operation.getOperationId();
    }


}
