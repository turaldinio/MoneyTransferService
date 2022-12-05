package ru.guluev.moneytransferservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.guluev.moneytransferservice.beans.ConfirmOperation;
import ru.guluev.moneytransferservice.beans.Operation;
import ru.guluev.moneytransferservice.model.TransferManager;
import ru.guluev.moneytransferservice.service.CardTransferService;

@RestController
public class CartTransferController {
    private final CardTransferService cartTransferService;

    public CartTransferController(CardTransferService cartTransferService) {
        this.cartTransferService = cartTransferService;
    }

    @CrossOrigin
    @PostMapping("/transfer")
    public Operation transfer(@RequestBody TransferManager transferManager) {
        return cartTransferService.transferMoney(transferManager);
    }

    @CrossOrigin
    @PostMapping("/confirmOperation")
    public ResponseEntity<?> confirmOperation(@RequestBody ConfirmOperation operation) {
        return new ResponseEntity<>(cartTransferService.confirmOperation(operation), HttpStatus.OK);
    }


}
