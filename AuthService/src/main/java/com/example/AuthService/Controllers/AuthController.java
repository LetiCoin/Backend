package com.example.AuthService.Controllers;

import com.example.AuthService.Entities.ActivationRequest;
import com.example.AuthService.Entities.LoginRequest;
import com.example.AuthService.Entities.RegistrationRequest;
import com.example.AuthService.Entities.AuthResponse;
//import com.example.AuthService.Entities.UserDto;
import com.example.AuthService.Services.AuthService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    private final AuthService authService;
    @Autowired
    private AmqpTemplate amqpTemplate;
    private ObjectMapper mapper = new ObjectMapper();


    @Autowired
    public AuthController(final AuthService authService) {
        this.authService = authService;
    }
    @PostMapping(value = "/login")
    @Operation(
            description = "Login Endpoint"
    )
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping(value = "/register")
    @Operation(
            description = "Registration Endpoint"
    )
    public ResponseEntity<AuthResponse> register(@RequestBody RegistrationRequest registrationRequest){
        return ResponseEntity.ok(authService.register(registrationRequest));
    }

    @PostMapping(value = "/activate")
    @Operation(
            description = "Activation Endpoint"
    )
    public ResponseEntity<AuthResponse> activate(@RequestBody ActivationRequest activationRequest,
                                                 @RequestHeader("login") String login){
        return ResponseEntity.ok(authService.activate(activationRequest,login));
    }


}
