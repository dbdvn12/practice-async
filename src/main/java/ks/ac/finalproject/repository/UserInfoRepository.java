package ks.ac.finalproject.repository;

import ks.ac.finalproject.domain.UserInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserInfoRepository extends ReactiveMongoRepository<UserInfo, String> {
    Mono<UserInfo> findOneByEmail(String email);
}
