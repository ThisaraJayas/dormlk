package lk.dorm.dormlk.service;

import lk.dorm.dormlk.config.JwtProvider;
import lk.dorm.dormlk.entity.User;
import lk.dorm.dormlk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDetailsImpl implements UserDetails{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUserProfileByJwt(String jwt) throws Exception {
        String email = JwtProvider.getEmailFromToken(jwt);
        return findUserByEmail(email);
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);
        if(user==null){
            throw new Exception("User Not Found By Email");
        }
        return user;
    }
}
