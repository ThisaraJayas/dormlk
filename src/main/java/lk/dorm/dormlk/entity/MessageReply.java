package lk.dorm.dormlk.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class MessageReply {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 10000)
    private String reply;
    private LocalDateTime createdDateTime;

    @ManyToOne
    @JoinColumn(name = "message_id")
    private Message message;
}
