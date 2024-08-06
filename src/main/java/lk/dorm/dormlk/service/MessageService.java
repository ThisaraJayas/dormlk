package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.Message;

public interface MessageService {
    Message createMessage(Long postId, String fullName, String email, String mobileNo, String message, Long id) throws Exception;
}
