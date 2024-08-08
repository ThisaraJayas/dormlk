package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.Message;

import java.util.List;

public interface MessageService {
    Message createMessage(Long postId, String fullName, String email, String mobileNo, String message, Long id) throws Exception;

    List<Message> findMessagesByUserId(Long userId);

    List<Message> findRecivedMessagesByUserId(Long id);
}
