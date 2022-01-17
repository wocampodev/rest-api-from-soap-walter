package dev.wocampo.restapi.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ws.soap.client.SoapFaultClientException;

import dev.wocampo.restapi.helpers.ResponseHandler;

@ControllerAdvice
public class GeneralAdvice {

    @ExceptionHandler(SoapFaultClientException.class)
    public ResponseEntity<?> handler(SoapFaultClientException ex) {
        return ResponseHandler.withError(ex.getFaultStringOrReason(),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handler(Exception ex) {
        return ResponseHandler.withError("Error interno. Contacte con el administrador.",
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
