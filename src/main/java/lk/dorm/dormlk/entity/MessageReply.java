package lk.dorm.dormlk.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private User user;

    @ManyToOne
    @JoinColumn(name = "message_id")
    @JsonIgnore
    private Message message;
}
