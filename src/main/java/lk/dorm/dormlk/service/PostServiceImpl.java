package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.Post;
import lk.dorm.dormlk.entity.PostStatus;
import lk.dorm.dormlk.entity.User;
import lk.dorm.dormlk.exceptions.PostNotFoundException;
import lk.dorm.dormlk.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        createdPost.setPrice(post.getPrice());
        createdPost.setMobileContact(post.getMobileContact());
        createdPost.setWhatsappContact(post.getWhatsappContact());
        createdPost.setEmailContact(post.getEmailContact());
        createdPost.setAvailability(post.getAvailability());
        createdPost.setSuitableFor(post.getSuitableFor());
        createdPost.setAccommodationType(post.getAccommodationType());
        createdPost.setCloseByLocation(post.getCloseByLocation());
        createdPost.setImages(post.getImages());
        createdPost.setCityDistrict(post.getCityDistrict());
        createdPost.setNoOfBathroom(post.getNoOfBathroom());
        createdPost.setNoOfBed(post.getNoOfBed());
        createdPost.setReviews(post.getReviews());
        createdPost.setPostStatus(PostStatus.PENDING);
        createdPost.setCreatedDateTime(LocalDateTime.now());


        return postRepository.save(createdPost);
    }

    @Override
    public List<Post> findPostsByDistrict(String districts) {

        return postRepository.findByCityDistrict(districts);
    }

    @Override
    public List<Post> filterPostBySearchHome(String district, String accommodationType) {
        return postRepository.findByCityDistrictAndAccommodationType(district,accommodationType);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> findPostByHouseType(String accommodationType) {
        return postRepository.findByAccommodationType(accommodationType);
    }

    @Override
    public List<Post> findPostsByUserId(Long userId) {

        return postRepository.findByUserId(userId);
    }

    @Override
    public Post updateStatus(Long postId, PostStatus status) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post not found with id: " + postId));
        post.setPostStatus(status);
        return postRepository.save(post);
    }

    @Override
    public Post findPostByPostId(Long postId) {
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException("Post not found with id: " + postId));
    }

    @Override
    public void deletePostById(Long postId) {
        postRepository.deleteById(postId);
    }
}
