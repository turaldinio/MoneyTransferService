package ru.guluev.moneytransferservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.guluev.moneytransferservice.exceptions.ErrorConfirmation;
import ru.guluev.moneytransferservice.exceptions.ErrorInputDate;
import ru.guluev.moneytransferservice.exceptions.ErrorTransfer;

@RestControllerAdvice
public class ExceptionController {


    @ExceptionHandler(ErrorInputDate.class)
    public ResponseEntity<?> errorInputDate(ErrorInputDate errorInputDate) {
        return new ResponseEntity<>(errorInputDate.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorConfirmation.class)
    public ResponseEntity<?> errorConfirmation(ErrorConfirmation errorConfirmation) {
        return new ResponseEntity<>(errorConfirmation.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(ErrorTransfer.class)
    public ResponseEntity<?> errorTransfer(ErrorTransfer errorTransfer) {
        return new ResponseEntity<>(errorTransfer.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
