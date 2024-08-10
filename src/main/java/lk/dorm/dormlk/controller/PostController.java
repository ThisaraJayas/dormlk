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

    @GetMapping("/district/{districts}")
    public ResponseEntity<List<Post>>getPostByDistrict(@PathVariable String districts){
        List<Post> posts = postService.findPostsByDistrict(districts);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post>getPostById(@PathVariable Long postId){
        Post post = postService.findPostByPostId(postId);
        return new ResponseEntity<>(post,HttpStatus.OK);
    }
    @GetMapping("/accommodationType/{accommodationType}")
    public ResponseEntity<List<Post>>getPostByHouseType(@PathVariable String accommodationType){
        List<Post> posts = postService.findPostByHouseType(accommodationType);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Post>>getPostBySearchHome(
            @RequestParam(required = false)String district,
            @RequestParam(required = false)String accommodationType){
        List<Post> searchPost = postService.filterPostBySearchHome(district,accommodationType);
        return new ResponseEntity<>(searchPost,HttpStatus.OK);
    }

    @GetMapping("/allPosts")
    public ResponseEntity<List<Post>>getAllPosts(){
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
    @GetMapping("/posts/{userId}")
    public ResponseEntity<List<Post>>getPostsByUserId(@PathVariable Long userId){
        List<Post> posts = postService.findPostsByUserId(userId);
        return new ResponseEntity<>(posts,HttpStatus.OK);
    }
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePostById(@PathVariable Long postId) {
        postService.deletePostById(postId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
