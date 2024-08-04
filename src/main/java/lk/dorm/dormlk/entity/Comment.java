package lk.dorm.dormlk.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String content;
    private LocalDateTime createdDateTime;
    private Integer starRating;

    @ManyToOne
    private User user;

    @ManyToOne
    private Post post;


}
