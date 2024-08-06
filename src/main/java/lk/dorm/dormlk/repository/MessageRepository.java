package lk.dorm.dormlk.repository;

import lk.dorm.dormlk.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {
}
