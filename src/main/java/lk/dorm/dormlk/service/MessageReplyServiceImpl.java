package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.Message;
import lk.dorm.dormlk.entity.MessageReply;
import lk.dorm.dormlk.entity.Post;
import lk.dorm.dormlk.entity.User;
import lk.dorm.dormlk.repository.MessageReplyRepository;
import lk.dorm.dormlk.repository.MessageRepository;
import lk.dorm.dormlk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MessageReplyServiceImpl implements MessageReplyService{

    @Autowired
    private MessageReplyRepository replyRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public MessageReply createReply(Long messageId, String reply, Long id) throws Exception {
        Optional<Message> messageOptional = messageRepository.findById(messageId);
        Optional<User> userOptional = userRepository.findById(id);

        if(messageOptional.isEmpty()){
            throw new Exception("Message not found with id "+messageId);
        }
        if(userOptional.isEmpty()){
            throw new Exception("User not found with userId "+id);
        }
        Message message = messageOptional.get();
        User user = userOptional.get();

        MessageReply messageReply = new MessageReply();
        messageReply.setMessage(message);
        messageReply.setUser(user);
        messageReply.setReply(reply);
        messageReply.setCreatedDateTime(LocalDateTime.now());

        MessageReply savedReply = replyRepository.save(messageReply);
        message.getReplies().add(savedReply);
        return savedReply;
    }
}
