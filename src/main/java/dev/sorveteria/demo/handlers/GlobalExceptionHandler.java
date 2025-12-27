package dev.sorveteria.demo.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import dev.sorveteria.demo.Dtos.ApiErrorDto;
import dev.sorveteria.demo.Exeptions.NotFoundExeption;

@RestControllerAdvice
public class GlobalExceptionHandler{
    
    @ExceptionHandler(NotFoundExeption.class)
    public ResponseEntity<ApiErrorDto> handleNotFound(NotFoundExeption ex) {
        return ResponseEntity
            .status(HttpStatus.NOT_FOUND)
            .body(new ApiErrorDto(404, ex.getMessage()));
    }
}