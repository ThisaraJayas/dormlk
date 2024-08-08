package lk.dorm.dormlk.controller;

import lk.dorm.dormlk.entity.Message;
import lk.dorm.dormlk.entity.MessageReply;
import lk.dorm.dormlk.entity.User;
import lk.dorm.dormlk.request.CreateMessageRequest;
import lk.dorm.dormlk.request.CreateReplyRequest;
import lk.dorm.dormlk.service.MessageReplyService;
import lk.dorm.dormlk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reply")
public class MessageReplyController {

    @Autowired
    private MessageReplyService messageReplyService;

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<MessageReply> createReply(@RequestBody CreateReplyRequest replyRequest, @RequestHeader("Authorization")String jwt) throws Exception {
        User user =userService.findUserProfileByJwt(jwt);
        MessageReply reply = messageReplyService.createReply(replyRequest.getMessageId(),replyRequest.getReply(),user.getId());
        return new ResponseEntity<>(reply, HttpStatus.OK);
    }
}
