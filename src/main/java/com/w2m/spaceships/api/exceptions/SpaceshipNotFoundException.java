package com.w2m.spaceships.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class SpaceshipNotFoundException extends RuntimeException {

    public SpaceshipNotFoundException(Long id) {
        super("Spaceship with ID " + id + " not found.");
    }
}
