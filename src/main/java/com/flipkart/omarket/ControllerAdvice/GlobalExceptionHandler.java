package com.flipkart.omarket.ControllerAdvice;

import com.flipkart.omarket.Dto.ExceptionDto;
import com.flipkart.omarket.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> arithmeticExceptionhandler(){
        ExceptionDto dto = new ExceptionDto();
        dto.setMsg("there is an Arithmetic Exception ");
        dto.setSolution("I dont know pls try again!! ");
        ResponseEntity<ExceptionDto>  response=new ResponseEntity<>(
                dto, HttpStatus.BAD_REQUEST
        );
        return response;
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> productNotFoundException(){
        ExceptionDto dto = new ExceptionDto();
        dto.setMsg("Product not found ");
        dto.setSolution("try with other inputs");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(
                dto,HttpStatus.BAD_REQUEST
        );
        return response ;

    }


}
