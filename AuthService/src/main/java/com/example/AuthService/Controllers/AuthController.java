package com.example.AuthService.Controllers;

import com.example.AuthService.Exception.AuthExcept;
import com.example.AuthService.Request.ActivationRequest;
import com.example.AuthService.Request.LoginRequest;
import com.example.AuthService.Request.RegistrationRequest;
import com.example.AuthService.Response.AuthResponse;
//import com.example.AuthService.Entities.UserDto;
import com.example.AuthService.Response.Response;
import com.example.AuthService.Services.AuthService;
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
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) throws AuthExcept {
        return ResponseEntity.ok(authService.login(loginRequest));
    }

    @PostMapping(value = "/register")
    @Operation(
            description = "Registration Endpoint"
    )
    public ResponseEntity<AuthResponse> register(@RequestBody RegistrationRequest registrationRequest) throws AuthExcept {
        return ResponseEntity.ok(authService.register(registrationRequest));
    }

    @PostMapping(value = "/activate")
    @Operation(
            description = "Activation Endpoint"
    )
    public ResponseEntity<AuthResponse> activate(@RequestBody ActivationRequest activationRequest,
                                                 @RequestHeader("login") String login) throws AuthExcept {
        return ResponseEntity.ok(authService.activate(activationRequest,login));
    }

    @GetMapping(value = "test")
    public ResponseEntity<Response> test(@RequestBody Response response) throws Exception {
        if(response.getMessage().equals("exception")){
            throw new Exception("this is except");
        }
        response.setMessage("ok");
        return ResponseEntity.ok(response);
    }

}
