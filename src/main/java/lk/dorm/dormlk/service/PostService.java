package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.Post;
import lk.dorm.dormlk.entity.User;

import java.util.List;

public interface PostService {
    Post createPost(Post post, User user);

    List<Post> findPostsByDistrict(String districts);

    List<Post> filterPostBySearchHome(String district, String accommodationType);

    List<Post> getAllPosts();

    List<Post> findPostByHouseType(String accommodationType);

    List<Post> findPostsByUserId(Long userId);
}
