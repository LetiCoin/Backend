package com.example.AuthService.Services;


import com.example.AuthService.Entities.*;
import com.example.AuthService.Exception.AuthExcept;
import com.example.AuthService.Request.ActivationRequest;
import com.example.AuthService.Request.LoginRequest;
import com.example.AuthService.Request.RegistrationRequest;
import com.example.AuthService.Response.AuthResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JwtUtil jwt;
    private final UserService userService;
    private final AmqpTemplate amqpTemplate;
    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    public AuthService(final JwtUtil jwt,
                        UserService userService,
                       AmqpTemplate amqpTemplate) {
        this.jwt = jwt;
        this.userService = userService;
        this.amqpTemplate = amqpTemplate;
    }

    public AuthResponse register(RegistrationRequest registrationRequest) throws AuthExcept {
        User user = userService.findByLogin(registrationRequest.getLogin());
        if(user != null){
            throw new AuthExcept("Username already exist");
        }
        user = new User(registrationRequest);
        user.setPassword(BCrypt.hashpw(registrationRequest.getPassword(), BCrypt.gensalt()));

        userService.register(user);

        String accessToken = jwt.generate(user, "ACCESS");
        String refreshToken = jwt.generate(user, "REFRESH");

        return new AuthResponse(accessToken, refreshToken);
    }

    public AuthResponse activate(ActivationRequest request, String login) throws AuthExcept {
        User user = userService.findByLogin(login);
        ActivationDto activationDto = new ActivationDto(request,user);
        if(user.getStatusId() == 1L) {
            throw new AuthExcept("Already active");
        }


        /*
        Rabbit
        Creating account on User Service
         */

        user.setStatusId(1L);
        userService.save(user);

        String accessToken = jwt.generate(user, "ACCESS");
        String refreshToken = jwt.generate(user, "REFRESH");

        return new AuthResponse(accessToken, refreshToken);
    }

    public AuthResponse login(LoginRequest request) throws AuthExcept {
        User user = userService.findByLogin(request.getLogin());
        if(user == null){
            throw new AuthExcept("Invalid data");
        }
        boolean correct = BCrypt.checkpw(request.getPassword(),user.getPassword());
        if(!correct){
            throw new AuthExcept("Invalid data");
        }
        String accessToken = jwt.generate(user, "ACCESS");
        String refreshToken = jwt.generate(user, "REFRESH");
        return new AuthResponse(accessToken, refreshToken);
    }
}
