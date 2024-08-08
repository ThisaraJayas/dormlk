package lk.dorm.dormlk.repository;

import lk.dorm.dormlk.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    List<Message> findByUserId(Long userId);

    @Query("SELECT m FROM Message m WHERE m.post.user.id = :userId")
    List<Message> findMessagesByUserId(@Param("userId") Long id);
}
