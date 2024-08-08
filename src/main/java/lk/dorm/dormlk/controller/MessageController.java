package lk.dorm.dormlk.controller;

import lk.dorm.dormlk.entity.Message;
import lk.dorm.dormlk.entity.User;
import lk.dorm.dormlk.request.CreateMessageRequest;
import lk.dorm.dormlk.service.MessageService;
import lk.dorm.dormlk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Message> createMessage(@RequestBody CreateMessageRequest messageRequest, @RequestHeader("Authorization")String jwt) throws Exception {
        User user =userService.findUserProfileByJwt(jwt);
        Message message = messageService.createMessage(messageRequest.getPostId(),messageRequest.getFullName(),messageRequest.getEmail(),messageRequest.getMobileNo(),messageRequest.getMessage(),user.getId());
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/messages/{userId}")
    public ResponseEntity<List<Message>> getMessagesByUserId(@PathVariable Long userId){
        List<Message> messages = messageService.findMessagesByUserId(userId);
        return new ResponseEntity<>(messages,HttpStatus.OK);
    }

    @GetMapping("/received")
    public ResponseEntity<List<Message>> getReceivedMessages(@RequestHeader("Authorization") String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        List<Message> messages = messageService.findRecivedMessagesByUserId(user.getId());
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

}
