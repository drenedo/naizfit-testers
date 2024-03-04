package me.renedo.naizfit.testers.api.http;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse runTimeException(RuntimeException ex) {
        return new ErrorResponse(ex.getClass().getCanonicalName(), ex.getMessage());
    }

    public record ErrorResponse(String type, String message) {
    }
}
