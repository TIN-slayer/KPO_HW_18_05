package ru.hse.list.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IDAlreadyExistsException extends RuntimeException {

    public IDAlreadyExistsException() {
        super("Record with this ID is already exists");
    }
}
