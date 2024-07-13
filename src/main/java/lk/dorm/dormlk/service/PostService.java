package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.Post;
import lk.dorm.dormlk.entity.User;

public interface PostService {
    Post createPost(Post post, User user);
}
