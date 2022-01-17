package dev.wocampo.restapi.helpers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public final class ResponseHandler {

    private static final Map<String, Object> responseBody = new HashMap<>();
    private static final Map<String, Object> status = new HashMap<>();

    private ResponseHandler() {
    }

    public static ResponseEntity<?> withBody(Object data, HttpStatus code) {
        responseBody.put("data", data);
        status.put("code", code.value());
        status.put("message", "Operación exitosa.");
        responseBody.put("status", status);
        return new ResponseEntity<Object>(responseBody, null, code);
    }

    public static ResponseEntity<?> withNothing(HttpStatus code) {
        responseBody.put("data", null);
        status.put("code", code.value());
        status.put("message", "Operación exitosa.");
        responseBody.put("status", status);
        return new ResponseEntity<Object>(responseBody, null, code);
    }

    public static ResponseEntity<?> withError(Object data, HttpStatus code) {
        responseBody.put("data", null);
        status.put("code", code.value());
        status.put("message", data);
        responseBody.put("status", status);
        return new ResponseEntity<Object>(responseBody, null, code);
    }

}
