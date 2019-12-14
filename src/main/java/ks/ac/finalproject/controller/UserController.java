package ks.ac.finalproject.controller;

import ks.ac.finalproject.domain.UserDto;
import ks.ac.finalproject.domain.UserInfo;
import ks.ac.finalproject.repository.UserInfoRepository;
import ks.ac.finalproject.service.UserInfoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
public class UserController {

    private UserInfoService userInfoService;
    private UserInfoRepository userInfoRepository;

    public UserController(UserInfoService userInfoService, UserInfoRepository userInfoRepository) {
        this.userInfoService = userInfoService;
        this.userInfoRepository = userInfoRepository;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.POST, produces = "application/json;Charset=UTF-8")
    @ResponseBody
    public Mono<UserInfo> registration(@RequestBody UserDto user) {
        Mono<UserInfo> userInfoMono = userInfoRepository.save(new UserInfo(UUID.randomUUID().toString(),
                user.getEmail(), user.getPassword(), null, user.getUsername(), null, null));
        userInfoMono.subscribe(System.out::println);
        System.out.println(user.getEmail());
        return userInfoMono;
    }

//    @PutMapping("/api/users")
//    public Mono<UserInfo> updateUser

}
