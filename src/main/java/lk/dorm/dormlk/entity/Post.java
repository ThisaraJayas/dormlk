package lk.dorm.dormlk.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(length = 10000)
    private String description;
    private String price;
    private String mobileContact;
    private String emailContact;
    private String whatsappContact;
    private String availability;
    private String accommodationType;
    private String cityDistrict;
    private String noOfBed;
    private String noOfBathroom;

    @Enumerated(EnumType.STRING)
    private PostStatus postStatus = PostStatus.PENDING;

    @ElementCollection
    private List<String> facilities = new ArrayList<>();

    @ElementCollection
    private List<String> closeByLocation = new ArrayList<>();

    @ElementCollection
    private List<String>suitableFor=new ArrayList<>();

    @ElementCollection

    @CollectionTable(name = "post_images", joinColumns = @JoinColumn(name = "post_id"))
    @Column(name = "image_url", length = 5000)
    private List<String> images;


    @ManyToOne
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @JsonIgnore //hanlde recurssion problem
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true) //mapby dont create separate table go to issue and create nside
    private List<Comment>comments= new ArrayList<>();

    @JsonIgnore //hanlde recurssion problem
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL,orphanRemoval = true) //mapby dont create separate table go to issue and create nside
    private List<Message>messages= new ArrayList<>();
}
