package ks.ac.finalproject.controller;

import ks.ac.finalproject.config.PWEncoder;
import ks.ac.finalproject.domain.LoginVo;
import ks.ac.finalproject.domain.UserInfo;
import ks.ac.finalproject.domain.UserVo;
import ks.ac.finalproject.jwt.JwtUtil;
import ks.ac.finalproject.service.UserInfoService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.UnsupportedEncodingException;
import java.security.InvalidParameterException;
import java.util.UUID;

@RestController
public class UserController {

    private UserInfoService userInfoService;
    private JwtUtil jwtUtil;
    private PWEncoder pwEncoder;

    public UserController(UserInfoService userInfoService, JwtUtil jwtUtil, PWEncoder pwEncoder) {
        this.userInfoService = userInfoService;
        this.jwtUtil = jwtUtil;
        this.pwEncoder = pwEncoder;
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Mono<UserInfo> registration(@RequestBody UserVo user) {
        if (user.getEmail().equals(null)||user.getPassword().equals(null)||user.getUsername().equals(null))
            return Mono.error(new InvalidParameterException());
        return userInfoService.registration(new UserInfo(UUID.randomUUID().toString(), user.getEmail(),
                pwEncoder.encode(user.getPassword()), null, user.getUsername(), null, null));
    }

    @RequestMapping(value = "/api/users/login", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
    public Mono<UserInfo> authentication(@RequestBody LoginVo user) {
        return userInfoService.byEmail(user.getEmail()).flatMap(userInfo -> {
            try {
                if (pwEncoder.matches(user.getPassword(),userInfo.getPassword()))
                    userInfo.setToken(jwtUtil.generateToken(userInfo));
                else return Mono.error(new Exception());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return userInfoService.save(userInfo);
        });
    }

//    @RequestMapping(value = "/api/user", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
//    public Mono<UserInfo> curUser(@RequestHeader(value = "Authorization") String token) {
//
//    }

//    @RequestMapping(value = "/api/user", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
//    public Mono<UserInfo> updateUser(@RequestBody UpdateVo updatevo) {
//
//    }

}
