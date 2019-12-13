package ks.ac.finalproject.repository;

import ks.ac.finalproject.domain.UserInfo;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserInfoRepository extends ReactiveMongoRepository<UserInfo, String> {
}
