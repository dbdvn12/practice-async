package ks.ac.finalproject.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfo {
    @Id
    private String id;

    private String email;
    private String password;
    private String token;
    private String username;
    private String bio;
    private String image;
}
