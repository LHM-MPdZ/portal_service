/*
 * Copyright (c): it@M - Dienstleister für Informations- und Telekommunikationstechnik der Landeshauptstadt München, 2020
 */

package de.muenchen.demoservicempdz.shared;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Exceptionhandler for global domain exceptions.
 * Transforms them to HTTP Status Codes.
 *
 * @
 */
@Slf4j
@ControllerAdvice
public class RestExceptionHandler
        extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ObjectNotFoundException.class })
    protected ResponseEntity<Object> handleNotFound(final RuntimeException ex, final WebRequest request) {
        final String bodyOfResponse = "Object not found";
        log.error("Client Exception 404.", ex);
        return this.handleExceptionInternal(ex, bodyOfResponse,
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

}
