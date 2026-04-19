package com.kh.vira_dev.commonutils.exception;

public class DuplicateResourceException extends RuntimeException {

    public DuplicateResourceException(String message) {
        super(String.format("%s already exists.", message));
    }

}
