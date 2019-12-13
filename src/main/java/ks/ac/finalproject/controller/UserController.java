package ks.ac.finalproject.controller;

import ks.ac.finalproject.domain.UserDto;
import ks.ac.finalproject.domain.UserInfo;
import ks.ac.finalproject.service.UserInfoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    private UserInfoService userInfoService;

    @PostMapping("/api/users")
    public Mono<UserInfo> registration(@RequestBody UserDto userDto) {
        return userInfoService.registration(userDto);
    }

    @PutMapping("/api/users")
    public Mono<UserInfo> updateUser

}
