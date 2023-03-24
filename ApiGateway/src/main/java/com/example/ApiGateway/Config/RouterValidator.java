package com.example.ApiGateway.Config;

import jakarta.validation.constraints.Max;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class RouterValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/auth/register",
            "/auth/login"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

    public static final List<String> endpointsWithoutActivation = List.of(
            "/auth/activate"
    );

    public Predicate<ServerHttpRequest> isRequiresActivation =
            request -> endpointsWithoutActivation
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));
}