package com.acme.hello.platform.interfaces.rest.resources;

import java.util.UUID;

/**
 * Response object for greeting a developer.
 *
 * @param id       The {@link UUID} unique identifier of the greeting.
 * @param fullName The full name of the developer.
 * @param message  The greeting message.
 *
 * @author Open-Source Applications Development Team
 * @version 1.0
 * @since 2025-09-03
 */
public record GreetDeveloperResponse(UUID id, String fullName, String message) {

    /**
     * Constructor with auto-generated {@link UUID} and no full name.
     * @param message The greeting message.
     */
    public GreetDeveloperResponse(String message) {
        this(UUID.randomUUID(), null, message);
    }
}
