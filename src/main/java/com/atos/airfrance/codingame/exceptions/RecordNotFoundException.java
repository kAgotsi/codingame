package com.atos.airfrance.codingame.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <pre>
 * Title: RecordNotFoundException class
 * Description: Exception raised when record nor found.
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException
{
    /**
     * Raise RecordNotFound when no record not found in database
     * @param exception not record exception raised
     */
    public RecordNotFoundException(String exception) {
        super(exception);
    }
}