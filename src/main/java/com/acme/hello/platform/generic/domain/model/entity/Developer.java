package com.acme.hello.platform.generic.domain.model.entity;

import lombok.Builder;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.UUID;

/**
 * @summary
 * Developer entity representing a software developer with a unique identifier, first name, and last name.
 * The class provides methods to retrieve the full name and check for blank names.
 *
 * @author Open-Source Applications Development Team
 * @version 1.0.0
 * @since 2025-09-03
 *
 */
@Getter
@Builder
public class Developer {
    private final UUID id = UUID.randomUUID();
    private final String firstName;
    private final String lastName;

    /**
     * Constructor for Developer.
     * Trims the first and last names to remove leading and trailing whitespace.
     * @param firstName The first name of the developer.
     * @param lastName  The last name of the developer.
     */
    public Developer(String firstName, String lastName) {
        this.firstName = StringUtils.trimToEmpty(firstName);
        this.lastName = StringUtils.trimToEmpty(lastName);
    }

    /**
     * Retrieves the full name of the developer by concatenating the first and last names.
     * If either name is blank, it will be omitted from the result.
     * @return The full name of the developer.
     */
    public String getFullName() {
        return String.format("%s %s", firstName, lastName).trim();
    }

    /**
     * Checks if either the first name or last name is blank (null, empty, or whitespace only).
     * @return true if either name is blank; false otherwise.
     */
    public boolean hasAnyNameBlank() {
        return StringUtils.isAnyBlank(firstName, lastName);
    }
}
