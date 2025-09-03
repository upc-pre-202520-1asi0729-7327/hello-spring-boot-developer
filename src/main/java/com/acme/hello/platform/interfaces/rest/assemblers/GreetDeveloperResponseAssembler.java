package com.acme.hello.platform.interfaces.rest.assemblers;

import com.acme.hello.platform.generic.domain.model.entity.Developer;
import com.acme.hello.platform.interfaces.rest.resources.GreetDeveloperResponse;
import org.apache.commons.lang3.ObjectUtils;

/**
 * Assembler to convert Developer entity to GreetDeveloperResponse resource.
 * Handles null or empty Developer instances by returning a default response.
 *
 * @author Open-Source Applications Development Team
 * @version 1.0.0
 * @since 2025-09-03
 */
public class GreetDeveloperResponseAssembler {
    /**
     * Check if the Developer instance is null or has empty name fields.
     * @param developer the {@link Developer} instance to check
     * @return true if the developer is null or has empty name fields, false otherwise
     */
    private static boolean isDeveloperNullOrEmptyNamed(Developer developer) {
        return ObjectUtils.isEmpty(developer)
                || developer.hasAnyNameBlank();
    }

    /**
     * Convert a Developer entity to a GreetDeveloperResponse resource.
     * If the Developer is null or has empty name fields, returns a default response.
     * @param entity the {@link Developer} entity to convert
     * @return the corresponding {@link GreetDeveloperResponse} resource
     */
    public static GreetDeveloperResponse toResponseFromEntity(Developer entity) {
        if (isDeveloperNullOrEmptyNamed(entity))
            return new GreetDeveloperResponse("Welcome Anonymous Spring Boot Developer");
        return new GreetDeveloperResponse(entity.getId(), entity.getFullName(),
                String.format("Congrats %s! You are an Spring Boot Developer!", entity.getFullName()));
    }
}
