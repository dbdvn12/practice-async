package ks.ac.finalproject.controller;

import ks.ac.finalproject.domain.UserDto;
import ks.ac.finalproject.domain.UserInfo;
import ks.ac.finalproject.service.UserInfoService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    private UserInfoService userInfoService;

    @RequestMapping(value = "/api/users",method = RequestMethod.POST)
    public Mono<UserInfo> registration(@RequestBody UserDto userDto) {
        return userInfoService.registration(userDto);
    }

//    @PutMapping("/api/users")
//    public Mono<UserInfo> updateUser

}
