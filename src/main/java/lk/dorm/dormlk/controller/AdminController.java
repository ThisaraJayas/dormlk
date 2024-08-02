package lk.dorm.dormlk.controller;

import lk.dorm.dormlk.entity.Post;
import lk.dorm.dormlk.entity.PostStatus;
import lk.dorm.dormlk.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private PostService postService;

    @GetMapping("/allPosts")
    public ResponseEntity<List<Post>> getAllPosts(){
        List<Post> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @PutMapping("/{postId}/status/{status}")
    public ResponseEntity<Post> updatePostStatus(@PathVariable Long postId, @PathVariable PostStatus status){
        Post updatedPost = postService.updateStatus(postId,status);
        return new ResponseEntity<>(updatedPost, HttpStatus.OK);
    }


}
