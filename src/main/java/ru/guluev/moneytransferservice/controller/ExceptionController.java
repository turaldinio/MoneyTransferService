package ru.guluev.moneytransferservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.guluev.moneytransferservice.enums.OperationStatus;
import ru.guluev.moneytransferservice.exceptions.ErrorConfirmation;
import ru.guluev.moneytransferservice.exceptions.ErrorInputDate;
import ru.guluev.moneytransferservice.exceptions.ErrorTransfer;
import ru.guluev.moneytransferservice.service.LoggerService;

@RestControllerAdvice
public class ExceptionController {

    @Autowired
    private LoggerService loggerService;


    @ExceptionHandler(ErrorInputDate.class)
    public ResponseEntity<?> errorInputDate(ErrorInputDate errorInputDate) {
        loggerService.writeLog(errorInputDate.getExceptionResponse(), OperationStatus.UNSUCCESSFULLY);
        return new ResponseEntity<>(errorInputDate.getExceptionResponse(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ErrorConfirmation.class)
    public ResponseEntity<?> errorConfirmation(ErrorConfirmation errorConfirmation) {
        loggerService.writeLog(errorConfirmation.getExceptionResponse(), OperationStatus.UNSUCCESSFULLY);
        return new ResponseEntity<>(errorConfirmation.getExceptionResponse(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @ExceptionHandler(ErrorTransfer.class)
    public ResponseEntity<?> errorTransfer(ErrorTransfer errorTransfer) {
        loggerService.writeLog(errorTransfer.getExceptionResponse(), OperationStatus.UNSUCCESSFULLY);
        return new ResponseEntity<>(errorTransfer.getExceptionResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
