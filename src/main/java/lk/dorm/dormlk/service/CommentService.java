package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.Comment;

public interface CommentService {
    Comment createComment(String content, Long postId, Long id);
}
