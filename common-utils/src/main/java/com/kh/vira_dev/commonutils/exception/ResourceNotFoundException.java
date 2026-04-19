package com.kh.vira_dev.commonutils.exception;

import java.util.NoSuchElementException;

public class ResourceNotFoundException extends NoSuchElementException {

    public ResourceNotFoundException(String resourceName , Long resourceId) {
        super(String.format("%s not found with ID %s.", resourceName, resourceId));
    }

}
