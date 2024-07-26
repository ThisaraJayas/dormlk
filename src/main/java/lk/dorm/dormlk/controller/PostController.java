package lk.dorm.dormlk.controller;
import lk.dorm.dormlk.entity.Post;
import lk.dorm.dormlk.entity.User;
import lk.dorm.dormlk.service.PostService;
import lk.dorm.dormlk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Post>createPost(@RequestHeader("Authorization")String jwt, @RequestBody Post post) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);
        Post createdPost = postService.createPost(post,user);
        return new ResponseEntity<>(createdPost, HttpStatus.OK);
    }

    @GetMapping("/{districts}")
    public ResponseEntity<List<Post>>getPostByDistrict(@PathVariable String districts){
        List<Post> posts = postService.findPostsByDistrict(districts);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Post>>getPostBySearchHome(
            @RequestParam(required = false)String district,
            @RequestParam(required = false)String accommodationType){
        List<Post> searchPost = postService.filterPostBySearchHome(district,accommodationType);
        return new ResponseEntity<>(searchPost,HttpStatus.OK);
    }
}
