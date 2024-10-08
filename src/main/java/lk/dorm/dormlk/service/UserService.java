package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.User;

public interface UserService {
    User findUserProfileByJwt(String jwt) throws Exception;
    User findUserByEmail(String email) throws Exception;

}
