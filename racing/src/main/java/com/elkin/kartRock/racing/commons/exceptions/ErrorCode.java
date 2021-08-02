package com.elkin.kartRock.racing.commons.exceptions;

public interface ErrorCode {
    String EXCEPTION = "exception.";

    String name();

    default String messageCode() {
        return "exception." + this.name();
    }

}
