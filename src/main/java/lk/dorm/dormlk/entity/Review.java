package lk.dorm.dormlk.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private LocalDateTime dateTime;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;
}
