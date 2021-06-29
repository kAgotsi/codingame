package com.atos.airfrance.codingame.aspect;

import com.atos.airfrance.codingame.exceptions.RecordNotFoundException;
import com.atos.airfrance.codingame.utils.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Title: ExceptionsHandler class
 * Description: Use AOP programming to intercepts Exceptions
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
@SuppressWarnings({"unchecked","rawtypes"})
@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler
{

    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ResponseDTO> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ResponseDTO response = ResponseDTO.builder().status(HttpStatus.NOT_FOUND.toString()).message("Record Not Found").details(details).build();
        return new ResponseEntity(response,HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        List<String> details = new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ResponseDTO response = ResponseDTO.builder().status(HttpStatus.BAD_REQUEST.toString()).message("Validation errors").details(details).build();
        return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
    }
}