package com.example.UsersNews.Controller;

import com.example.UsersNews.Err.CheckUserException;
import com.example.UsersNews.Err.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import com.example.UsersNews.web.ErrResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
@Slf4j
@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrResponse> notFound(EntityNotFoundException ex) {
        log.error("Ошибка при попытке получить сущность", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrResponse(ex.getLocalizedMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrResponse> notValid(MethodArgumentNotValidException ex) {
        BindingResult bindingResult = ex.getBindingResult();
        List<String> errorMessages = bindingResult.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .toList();
        String errorMessage = String.join("; ", errorMessages);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrResponse(errorMessage));
    }

    @ExceptionHandler(CheckUserException.class)
    public ResponseEntity<ErrResponse> notCheck(CheckUserException ex) {
        log.error("Ошибка", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrResponse(ex.getLocalizedMessage()));
    }
}
