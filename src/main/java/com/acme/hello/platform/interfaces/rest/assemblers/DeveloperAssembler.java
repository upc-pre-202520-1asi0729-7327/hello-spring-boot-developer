package com.acme.hello.platform.interfaces.rest.assemblers;

import com.acme.hello.platform.generic.domain.model.entity.Developer;
import com.acme.hello.platform.interfaces.rest.resources.GreetDeveloperRequest;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * Assembler for Developer entity.
 * Converts a {@link GreetDeveloperRequest} to a {@link Developer} entity.
 *
 * @author Open-Source Applications Development Team
 * @version 1.0.0
 * @since 2025-09-03
 */
public class DeveloperAssembler {
    /**
     * Converts a {@link GreetDeveloperRequest} to a {@link Developer} entity.
     * Returns null if the request is null or if any of the required fields are blank.
     * @param request the {@link GreetDeveloperRequest} to convert
     * @return the converted {@link Developer} entity or null if the request is invalid
     */
    public static Developer toEntityFromRequest(GreetDeveloperRequest request) {
        if (ObjectUtils.isEmpty(request) ||
                StringUtils.isAnyBlank(request.firstName(), request.lastName()))
            return null;
        return Developer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .build();
    }
}
