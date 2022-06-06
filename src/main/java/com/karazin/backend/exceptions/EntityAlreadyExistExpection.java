package com.karazin.backend.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class EntityAlreadyExistExpection extends RuntimeException {
    public EntityAlreadyExistExpection(String message) {
        super(message);
    }
}
