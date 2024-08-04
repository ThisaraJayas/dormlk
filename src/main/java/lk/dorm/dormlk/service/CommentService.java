package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(String content, Long postId, Long id, Integer starRating) throws Exception;

    List<Comment> findCommentsByPostId(Long postId);
}
