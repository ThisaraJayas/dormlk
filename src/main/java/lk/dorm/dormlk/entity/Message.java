package lk.dorm.dormlk.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String email;
    private String mobileNo;
    private String message;
    private LocalDateTime createdDateTime;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;
}
