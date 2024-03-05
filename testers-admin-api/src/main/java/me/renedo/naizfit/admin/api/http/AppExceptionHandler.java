package me.renedo.naizfit.admin.api.http;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AppExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(AppExceptionHandler.class);


    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse runTimeException(RuntimeException ex) {
        log.error("Error", ex);
        return new ErrorResponse(ex.getClass().getCanonicalName(), ex.getMessage());
    }

    public record ErrorResponse(String type, String message) {
    }
}
