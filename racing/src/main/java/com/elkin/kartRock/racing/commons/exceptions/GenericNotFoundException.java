package com.elkin.kartRock.racing.commons.exceptions;

public class GenericNotFoundException extends KartException{
    public GenericNotFoundException(ErrorCode code) {
        super(code);
    }

    public GenericNotFoundException(ErrorCode code, Throwable cause) {
        super(code, cause);
    }
}
