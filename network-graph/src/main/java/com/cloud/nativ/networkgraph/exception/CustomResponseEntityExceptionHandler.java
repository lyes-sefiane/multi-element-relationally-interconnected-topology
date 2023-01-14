package com.cloud.nativ.networkgraph.exception;


import com.cloud.nativ.networkgraph.exception.entities.ExceptionResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author : Lyes Sefiane
 * @mailto : lyes.sefiane@gmail.com
 * @created : 2021-12-26 12:45 p.m.
 */
@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Handle Node Not Found
     *
     * @param ex : RuntimeException
     * @param request : WebRequest
     * @return responseEntity : ResponseEntity<Object>
     */
    @ExceptionHandler(NodeNotFoundException.class)
    public final ResponseEntity<Object> handleNodeNotFound(RuntimeException ex, WebRequest request) {

        return buildResponseEntity(//
                new ExceptionResponse(//
                        ex.getMessage(), //
                        HttpStatus.NOT_FOUND, //
                        ((ServletWebRequest) request).getRequest().getRequestURI()));
    }

    /**
     * Handle Http Message Not Readable
     *
     * Thrown when request JSON is malformed.
     *
     * @param ex
     * @param request
     * @return ResponseEntity<Object>
     */
    @Override
    public ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, //
                                                               HttpHeaders headers, //
                                                               HttpStatus status, //
                                                               WebRequest request) {

        return buildResponseEntity(new ExceptionResponse(//
                "malformed json request.", //
                HttpStatus.BAD_REQUEST, //
                ((ServletWebRequest) request).getRequest().getRequestURI()));
    }



    /**
     * Build Response Entity
     *
     * @param exceptionResponse : ExceptionResponse
     * @return responseEntity : ResponseEntity<Object>
     */
    private ResponseEntity<Object> buildResponseEntity(ExceptionResponse exceptionResponse) {
        return new ResponseEntity<>(exceptionResponse, exceptionResponse.getHttpStatus());
    }

}
