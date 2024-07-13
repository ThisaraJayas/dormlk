package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.Post;
import lk.dorm.dormlk.entity.User;
import lk.dorm.dormlk.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createPost(Post post, User user) {
        Post createdPost = new Post();
        createdPost.setUser(user);
        createdPost.setTitle(post.getTitle());
        createdPost.setDescription(post.getDescription());
        createdPost.setLocation(post.getLocation());
        createdPost.setFacilities(post.getFacilities());
        createdPost.setReviews(post.getReviews());

        return postRepository.save(createdPost);
    }
}
