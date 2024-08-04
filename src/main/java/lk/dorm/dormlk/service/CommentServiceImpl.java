package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.Comment;
import lk.dorm.dormlk.entity.Post;
import lk.dorm.dormlk.entity.User;
import lk.dorm.dormlk.repository.CommentRepository;
import lk.dorm.dormlk.repository.PostRepository;
import lk.dorm.dormlk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Comment createComment(String content, Long postId, Long id) throws Exception {
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

        Comment comment = new Comment();
        comment.setPost(post);
        comment.setUser(user);
        comment.setCreatedDateTime(LocalDateTime.now());
        comment.setContent(content);

        Comment savedComment = commentRepository.save(comment);
        post.getComments().add(savedComment);
        return savedComment;

    }

    @Override
    public List<Comment> findCommentsByPostId(Long postId) {
        return commentRepository.findByPostId(postId);
    }
}
