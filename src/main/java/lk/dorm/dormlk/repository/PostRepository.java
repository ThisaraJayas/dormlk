package lk.dorm.dormlk.repository;

import lk.dorm.dormlk.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByCityDistrict(String districts);

    List<Post> findByCityDistrictAndAccommodationType(String cityDistrict, String accommodationType);

    List<Post> findByAccommodationType(String accommodationType);

    List<Post> findByUserId(Long userId);
}
