package ks.ac.finalproject.service;

import ks.ac.finalproject.config.PWEncoder;
import ks.ac.finalproject.domain.UserVo;
import ks.ac.finalproject.domain.UserInfo;
import ks.ac.finalproject.repository.UserInfoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.security.InvalidParameterException;
import java.util.UUID;

@Service
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;
    private PWEncoder pwEncoder;

    public UserInfoService(UserInfoRepository userInfoRepository, PWEncoder pwEncoder) {
        this.userInfoRepository = userInfoRepository;
        this.pwEncoder = pwEncoder;
    }

    public Mono<UserInfo> registration(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    public Mono<UserInfo> byEmail(String email) {
        return userInfoRepository.findOneByEmail(email);
    }

    public Mono<UserInfo> save(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }
//    public Mono<UserInfo> auth(LoginVo user) {
//
//        return curUser;
//    }

//    public Mono<UserInfo> update()

}
