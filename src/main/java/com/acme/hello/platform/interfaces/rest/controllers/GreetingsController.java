package com.acme.hello.platform.interfaces.rest.controllers;

import com.acme.hello.platform.generic.domain.model.entity.Developer;
import com.acme.hello.platform.interfaces.rest.assemblers.DeveloperAssembler;
import com.acme.hello.platform.interfaces.rest.assemblers.GreetDeveloperResponseAssembler;
import com.acme.hello.platform.interfaces.rest.resources.GreetDeveloperRequest;
import com.acme.hello.platform.interfaces.rest.resources.GreetDeveloperResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * Controller for greeting developers.
 * Handles GET and POST requests to greet developers.
 *
 * @summary
 * GET /api/v1/greetings?firstName={firstName}&lastName={lastName}
 * - Greets a developer with the provided first and last name.
 * - If either firstName or lastName is missing, returns a generic greeting.
 * POST /api/v1/greetings
 * - Accepts a JSON body with firstName and lastName to create a greeting.
 * - Returns a greeting message with HTTP status 201 (Created).
 *
 * @author Open-Source Applications Development Team
 * @version 1.0
 * @since 2025-09-03
 *
 */
@RestController
@RequestMapping("/api/v1/greetings")
public class GreetingsController {

    /**
     * Greets a developer based on query parameters.
     * @param firstName The first name of the developer.
     * @param lastName The last name of the developer.
     * @return A {@link ResponseEntity} containing the {@link GreetDeveloperResponse} greeting message.
     */
    @GetMapping
    public ResponseEntity<GreetDeveloperResponse> greetDeveloper(
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName) {
        Developer developer = (Objects.isNull(firstName) || Objects.isNull(lastName))
                ? null
                : Developer.builder()
                    .firstName(firstName)
                    .lastName(lastName)
                    .build();
        GreetDeveloperResponse response = GreetDeveloperResponseAssembler
                .toResponseFromEntity(developer);
        return ResponseEntity.ok(response);
    }

    /**
     * Creates a greeting for a developer based on the request body.
     * @param request The {@link GreetDeveloperRequest} containing the developer's details.
     * @return A {@link ResponseEntity} containing the {@link GreetDeveloperResponse} greeting message with HTTP status 201 (Created).
     */
    @PostMapping
    public ResponseEntity<GreetDeveloperResponse> createGreeting(
            @RequestBody GreetDeveloperRequest request) {
        Developer developer = DeveloperAssembler.toEntityFromRequest(request);
        GreetDeveloperResponse response = GreetDeveloperResponseAssembler
                .toResponseFromEntity(developer);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
