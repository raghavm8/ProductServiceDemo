package org.raghav.productservicedemo.Advices;

import org.raghav.productservicedemo.Dtos.ExceptionDto;
import org.raghav.productservicedemo.Exceptions.ProductLimitReachedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleException() {
        System.out.println("Something went Wrong");
        return new ResponseEntity<>("Something went Wrong", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductLimitReachedException.class)
    public ResponseEntity<ExceptionDto> handleException(Exception e) {
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage(e.getMessage());
        exceptionDto.setErrorCode("Product_Limit_Reached");

        return new ResponseEntity<>(exceptionDto, HttpStatus.CONFLICT);
    }
}
