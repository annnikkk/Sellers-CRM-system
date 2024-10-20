package org.example.test_shift;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.example.test_shift.exceptions.*;
import org.springframework.web.bind.annotation.*;



@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SellerNotFoundException.class)
    public ResponseEntity<String> handleSellerNotFound(SellerNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(DuplicateSellerException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleDuplicateSeller(DuplicateSellerException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(InvalidSellerInfoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleInvalidSellerData(InvalidSellerInfoException ex) {
        return ex.getMessage();
    }
}
