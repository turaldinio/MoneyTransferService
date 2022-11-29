package ru.guluev.moneytransferservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.guluev.moneytransferservice.model.Operation;
import ru.guluev.moneytransferservice.model.TransferManager;
import ru.guluev.moneytransferservice.server.CartTransferService;

@RestController
public class CartTransferController {
    private final CartTransferService cartTransferService;

    public CartTransferController(CartTransferService cartTransferService) {
        this.cartTransferService = cartTransferService;
    }

    @CrossOrigin
    @PostMapping("/transfer")
    public ResponseEntity<?> transfer(@RequestBody TransferManager transferManager) {
        return cartTransferService.transferMoney(transferManager);

    }

    @CrossOrigin
    @PostMapping("/confirmOperation")
    public ResponseEntity<?> confirmOperation(@RequestBody Operation operation) {
        return cartTransferService.confirmOperation(operation);
    }


}
