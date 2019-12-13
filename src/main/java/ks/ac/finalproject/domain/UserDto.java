package ks.ac.finalproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@AllArgsConstructor
@Getter
public class UserDto {
    private String username;
    private String email;
    private String password;
}
