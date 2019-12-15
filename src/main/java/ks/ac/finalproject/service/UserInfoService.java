package ks.ac.finalproject.service;

import ks.ac.finalproject.domain.LoginVo;
import ks.ac.finalproject.domain.UserVo;
import ks.ac.finalproject.domain.UserInfo;
import ks.ac.finalproject.repository.UserInfoRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;
    PasswordEncoder encoder = new BCryptPasswordEncoder();

    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public Mono<UserInfo> registration(UserVo user) {
        return userInfoRepository.save(new UserInfo(UUID.randomUUID().toString(), user.getEmail(),
                encoder.encode(user.getPassword()), null, user.getUsername(), null, null));
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
