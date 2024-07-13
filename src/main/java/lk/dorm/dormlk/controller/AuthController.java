package lk.dorm.dormlk.controller;

import lk.dorm.dormlk.entity.User;
import lk.dorm.dormlk.request.LoginRequest;
import lk.dorm.dormlk.response.AuthResponse;
import lk.dorm.dormlk.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> createUser(@RequestBody User user) throws Exception {
        AuthResponse response =authService.signup(user);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest loginRequest){
        AuthResponse response =authService.signin(loginRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
