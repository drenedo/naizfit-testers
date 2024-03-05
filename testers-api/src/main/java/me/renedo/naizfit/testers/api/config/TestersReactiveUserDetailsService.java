package me.renedo.naizfit.testers.api.config;

import java.util.Optional;

import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import me.renedo.naizfit.testers.infraestructure.jpa.TesterEntity;
import me.renedo.naizfit.testers.infraestructure.jpa.TesterEntityRepository;
import reactor.core.publisher.Mono;

@Service
public class TestersReactiveUserDetailsService implements ReactiveUserDetailsService {

    private final TesterEntityRepository testerEntityRepository;

    public TestersReactiveUserDetailsService(TesterEntityRepository testerEntityRepository) {
        this.testerEntityRepository = testerEntityRepository;
    }

    @Override
    public Mono<UserDetails> findByUsername(String username) {
        return Mono.fromCallable(() -> testerEntityRepository.findByEmail(username))
                .switchIfEmpty(Mono.defer(() -> Mono.error(new UsernameNotFoundException("User Not Found"))))
                .map(Optional::get)
                .mapNotNull(this::toUserDetails);
    }

    private UserDetails toUserDetails(TesterEntity tester) {
        return User.withUsername(tester.getId().toString())
                .password(tester.getPassword())
                .roles("USER")
                .build();
    }
}
