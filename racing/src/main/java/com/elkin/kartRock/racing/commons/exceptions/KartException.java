package com.elkin.kartRock.racing.commons.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.elkin.kartRock.racing.commons.exceptions.ErrorCode;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public abstract class KartException extends RuntimeException{

    private final ErrorCode code;


    public KartException(ErrorCode code) {
        super(code.name());
        this.code = code;
    }

    public KartException(ErrorCode code, Throwable cause) {
        super(code.name(), cause);
        this.code = code;
    }

    public ErrorCode getCode() {
        return this.code;
    }
}
