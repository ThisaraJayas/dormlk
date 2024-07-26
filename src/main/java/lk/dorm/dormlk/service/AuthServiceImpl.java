package lk.dorm.dormlk.service;

import lk.dorm.dormlk.config.JwtProvider;
import lk.dorm.dormlk.entity.User;
import lk.dorm.dormlk.entity.UserType;
import lk.dorm.dormlk.exceptions.UserAlreadyExistsException;
import lk.dorm.dormlk.repository.UserRepository;
import lk.dorm.dormlk.request.LoginRequest;
import lk.dorm.dormlk.response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsImpl customUserDetails;

    @Override
    public AuthResponse signup(User user) throws Exception, UserAlreadyExistsException {
        User isUserExit = userRepository.findByEmail(user.getEmail());
        if(isUserExit!=null){
            throw new UserAlreadyExistsException("User Found with the Email");
        }

        User createdUser = new User();
        createdUser.setFirstName(user.getFirstName());
        createdUser.setLastName(user.getLastName());
        createdUser.setEmail(user.getEmail());
        createdUser.setPassword(passwordEncoder.encode(user.getPassword()));
        createdUser.setUserType(UserType.REGULAR);

        User savedUser = userRepository.save(createdUser);

        Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = JwtProvider.generateToken(authentication);

        AuthResponse response = new AuthResponse();
        response.setMessage("Signup success");
        response.setJwt(jwt);
        return response;
    }

    @Override
    public AuthResponse signin(LoginRequest loginRequest) {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();

        //authenticate email and password
        Authentication authentication = authenticate(email,password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = JwtProvider.generateToken(authentication);
        AuthResponse response = new AuthResponse();
        response.setMessage("Signin Success");
        response.setJwt(jwt);
        return response;
    }

    private Authentication authenticate(String email, String password) {
        UserDetails userDetails = customUserDetails.loadUserByUsername(email);
        if(userDetails==null){
            throw new BadCredentialsException("Invalid Email");
        }
        if(!passwordEncoder.matches(password,userDetails.getPassword())){
            throw new BadCredentialsException("Invalid password");
        }
        return new PreAuthenticatedAuthenticationToken(userDetails,null,userDetails.getAuthorities());
    }
}
