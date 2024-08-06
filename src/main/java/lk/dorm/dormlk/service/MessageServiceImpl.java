package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.Message;
import lk.dorm.dormlk.entity.Post;
import lk.dorm.dormlk.entity.User;
import lk.dorm.dormlk.repository.MessageRepository;
import lk.dorm.dormlk.repository.PostRepository;
import lk.dorm.dormlk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;
    @Override
    public Message createMessage(Long postId, String fullName, String email, String mobileNo, String message, Long id) throws Exception {
        Optional<Post> postOptional = postRepository.findById(postId);
        Optional<User> userOptional = userRepository.findById(id);

        if(postOptional.isEmpty()){
            throw new Exception("Post not found with id "+postId);
        }
        if(userOptional.isEmpty()){
            throw new Exception("User not found with userId "+id);
        }
        Post post = postOptional.get();
        User user = userOptional.get();

        Message message1 = new Message();
        message1.setPost(post);
        message1.setUser(user);
        message1.setFullName(fullName);
        message1.setEmail(email);
        message1.setMobileNo(mobileNo);
        message1.setMessage(message);
        message1.setCreatedDateTime(LocalDateTime.now());

        Message saVedMessage = messageRepository.save(message1);
        post.getMessages().add(saVedMessage);
        return saVedMessage;
    }
}
