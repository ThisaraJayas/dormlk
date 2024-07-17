package lk.dorm.dormlk.service;

import lk.dorm.dormlk.entity.Post;
import lk.dorm.dormlk.entity.User;
import lk.dorm.dormlk.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


        return postRepository.save(createdPost);
    }

    @Override
    public List<Post> findPostsByDistrict(String districts) {
        return postRepository.findByCityDistrict(districts);
    }
}
