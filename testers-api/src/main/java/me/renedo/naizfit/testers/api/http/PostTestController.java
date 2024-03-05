package me.renedo.naizfit.testers.api.http;

import java.util.UUID;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.renedo.naizfit.testers.application.test.CreateTestCommand;
import me.renedo.naizfit.testers.application.test.CreateTestUseCase;
import reactor.core.publisher.Mono;

@RestController
@Tag(name = "Test", description = "Test API")
public class PostTestController {

    private final CreateTestUseCase createTestUseCase;

    public PostTestController(CreateTestUseCase createTestUseCase) {
        this.createTestUseCase = createTestUseCase;
    }

    @PostMapping(value = "/v1/test")
    @Operation(summary = "Create test", description = "Create test")
    public Mono<Void> createTestV1(@RequestBody Test test) {
        return ReactiveSecurityContextHolder.getContext().map(SecurityContext::getAuthentication)
                .flatMap(auth -> getResponseFromAuthentication(test, auth));
    }

    private Mono<Void> getResponseFromAuthentication(Test test, Authentication auth) {
        if (auth != null) {
            return Mono.create(sink -> {
                try {
                    createTestUseCase.execute(toCommand(test, auth));
                    sink.success();
                } catch (Exception e) {
                    sink.error(e);
                }
            });
        } else {
            return Mono.empty();
        }
    }

    private CreateTestCommand toCommand(Test test, Authentication authentication) {
        return new CreateTestCommand(test.id(), UUID.fromString(((User) authentication.getPrincipal()).getUsername()), test.productId(), test.size());
    }

    public record Test(UUID id, UUID productId, String size) {

    }
}
