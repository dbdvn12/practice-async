package ks.ac.finalproject.controller;

import ks.ac.finalproject.domain.LoginVo;
import ks.ac.finalproject.domain.UserInfo;
import ks.ac.finalproject.domain.UserVo;
import ks.ac.finalproject.repository.UserInfoRepository;
import ks.ac.finalproject.service.JwtService;
import ks.ac.finalproject.service.UserInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;

@RestController
public class UserController {

    private UserInfoService userInfoService;
    private JwtService jwtService;

    public UserController(UserInfoService userInfoService, JwtService jwtService) {
        this.userInfoService = userInfoService;
        this.jwtService = jwtService;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Mono<UserInfo> registration(@RequestBody UserVo user) {
        return userInfoService.registration(user);
    }

    @RequestMapping(value = "/api/users/login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Mono<UserInfo> authentication(@RequestBody LoginVo user) {
        return userInfoService.byEmail(user.getEmail()).flatMap(userInfo -> {
            try {
                userInfo.setToken(jwtService.generateToken(userInfo));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return userInfoService.save(userInfo);
        });
    }

//    @RequestMapping(value = "/api/user", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
//    public Mono<UserInfo> curUser() {
//    }

//    @RequestMapping(value = "/api/user", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
//    public Mono<UserInfo> updateUser(@RequestBody UpdateVo updatevo) {
//
//    }

}
