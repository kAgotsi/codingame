package com.atos.airfrance.codingame.utils;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * <pre>
 * Title: ResponseDTO class
 * Description: Enables to constructs HTTP responses.
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
@Data
@Builder
public class ResponseDTO<T> {
    private String status;

    @Builder.Default
    private String message = "Success!";
    //Specific errors in API request processing
    private List<String> details;
    private T body;

}
