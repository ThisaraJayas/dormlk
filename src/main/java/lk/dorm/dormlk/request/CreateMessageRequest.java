package lk.dorm.dormlk.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMessageRequest {
    private Long postId;
    private String fullName;
    private String email;
    private String mobileNo;
    private String message;
}
