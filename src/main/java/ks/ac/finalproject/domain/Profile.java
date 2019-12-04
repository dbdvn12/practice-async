package ks.ac.finalproject.domain;

        import lombok.Getter;
        import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
public class Profile {
    private UserInfo userInfo;
    private String username;
    private String bio;
    private String image;
    private Boolean following;

    public Profile() {
        this.username = userInfo.getUsername();
        this.bio = userInfo.getBio();
        this.image = userInfo.getImage();
        this.following = false;
    }
}
