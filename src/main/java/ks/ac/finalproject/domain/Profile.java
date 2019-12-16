package ks.ac.finalproject.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Profile {
    private String username;
    private String bio;
    private String image;
    private Boolean following;

    public Profile(UserInfo userInfo) {
        this.username = userInfo.getUsername();
        this.bio = userInfo.getBio();
        this.image = userInfo.getImage();
        this.following = false;
    }
}
