package lk.dorm.dormlk.controller;

import lk.dorm.dormlk.entity.Comment;
import lk.dorm.dormlk.entity.User;
import lk.dorm.dormlk.request.CreateCommentRequest;
import lk.dorm.dormlk.service.CommentService;
import lk.dorm.dormlk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @PostMapping()
    public ResponseEntity<Comment>createComment(@RequestBody CreateCommentRequest request, @RequestHeader ("Authorization")String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Comment createdComment = commentService.createComment(request.getContent(),request.getPostId(),user.getId(), request.getStarRating());
        return new ResponseEntity<>(createdComment, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable Long postId){
        List<Comment> comments = commentService.findCommentsByPostId(postId);
        return new ResponseEntity<>(comments,HttpStatus.OK);
    }

}
