package lk.dorm.dormlk.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String location;
    private String description;
    private List<String> facilities = new ArrayList<>();

    @ManyToOne
    private User postedBy;
}
