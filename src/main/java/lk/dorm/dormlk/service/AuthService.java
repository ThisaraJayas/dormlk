package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.User;
import lk.dorm.dormlk.exceptions.UserAlreadyExistsException;
import lk.dorm.dormlk.request.LoginRequest;
import lk.dorm.dormlk.response.AuthResponse;
import org.springframework.stereotype.Service;


public interface AuthService {
    AuthResponse signup(User user) throws Exception, UserAlreadyExistsException;

    AuthResponse signin(LoginRequest loginRequest);
}
