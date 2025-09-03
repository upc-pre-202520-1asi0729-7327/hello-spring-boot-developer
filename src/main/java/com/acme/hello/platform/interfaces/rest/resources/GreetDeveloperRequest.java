package com.acme.hello.platform.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request object for greeting a developer.
 *
 * @param firstName The first name of the developer.
 * @param lastName  The last name of the developer.
 *
 * @author Open-Source Applications Development Team
 * @version 1.0
 * @since 2025-09-03
 */
public record GreetDeveloperRequest(String firstName, String lastName) {

    /** Constructor for JSON deserialization. */
    @JsonCreator
    public GreetDeveloperRequest(@JsonProperty("firstName") String firstName,
                                 @JsonProperty("lastName") String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
