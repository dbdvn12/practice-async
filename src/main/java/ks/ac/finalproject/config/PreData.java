package ks.ac.finalproject.config;

import ks.ac.finalproject.domain.UserInfo;
import ks.ac.finalproject.repository.UserInfoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class PreData implements CommandLineRunner {

    private final UserInfoRepository userInfoRepository;

    public PreData(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        userInfoRepository.deleteAll()
//                .thenMany(
//                        Flux.just(1)
//                                .map(user -> new UserInfo(UUID.randomUUID().toString(),
//                                        "wlrnjs121@gmail.com", "12345", null, "wlrnjs",
//                                        null, null))
//                                .flatMap(userInfoRepository::save))
//                .subscribe(System.out::println);
    }
}
