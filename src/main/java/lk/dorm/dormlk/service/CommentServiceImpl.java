package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.Comment;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
    @Override
    public Comment createComment(String content, Long postId, Long id) {
        return null;
    }
}
