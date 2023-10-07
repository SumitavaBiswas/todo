package com.sumitava.todo.uitls;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
@Getter
@Setter
public class ApiErrors {
    private Errors errors;
    private HttpStatus status;
    private String code;
    private String exception;
    private String timestamp;

    public ApiErrors(Errors errors){
        for(FieldError fieldError: errors.getFieldErrors()){
            code = fieldError.getField();
            exception = fieldError.getDefaultMessage();
            status = HttpStatus.BAD_REQUEST;
        }
    }

    @Override
    public String toString() {
        String message = "";
        for(FieldError fieldError: errors.getFieldErrors()){
            message = message + fieldError.getField() + fieldError.getDefaultMessage() +"\n";
        }
        return message;
    }
}
