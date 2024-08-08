package lk.dorm.dormlk.repository;

import lk.dorm.dormlk.entity.MessageReply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageReplyRepository extends JpaRepository<MessageReply,Long> {
}
