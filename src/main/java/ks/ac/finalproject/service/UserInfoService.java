package ks.ac.finalproject.service;

import ks.ac.finalproject.domain.UserDto;
import ks.ac.finalproject.domain.UserInfo;
import ks.ac.finalproject.repository.UserInfoRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserInfoService {

    private final UserInfoRepository userInfoRepository;

    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public Mono<UserInfo> registration(UserDto userDto) {
        return userInfoRepository.save(UserInfo.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .bio(null)
                .id(UUID.randomUUID().toString())
                .image(null)
                .token(null)
                .build());
    }

//    public Mono<UserInfo> update()

}
