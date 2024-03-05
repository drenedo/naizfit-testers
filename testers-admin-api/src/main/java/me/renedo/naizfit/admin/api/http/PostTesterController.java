package me.renedo.naizfit.admin.api.http;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.renedo.naizfit.testers.application.tester.CreateTesterCommand;
import me.renedo.naizfit.testers.application.tester.CreateTesterUseCase;

@RestController
@Tag(name = "Tester", description = "Tester API")
public class PostTesterController {

    private final PasswordEncoder passwordEncoder;

    private final CreateTesterUseCase createTesterUseCase;

    public PostTesterController(PasswordEncoder passwordEncoder, CreateTesterUseCase createTesterUseCase) {
        this.passwordEncoder = passwordEncoder;
        this.createTesterUseCase = createTesterUseCase;
    }

    @PostMapping(value = "/v1/tester")
    @Operation(summary = "Create tester", description = "Create tester")
    public ResponseEntity<Void> createTesterV1(@RequestBody Tester tester) {
        createTesterUseCase.execute(toCommand(tester));
        return ResponseEntity.ok().build();
    }

    private CreateTesterCommand toCommand(Tester tester) {
        return new CreateTesterCommand(tester.id(), tester.name(), tester.email(), passwordEncoder.encode(tester.password()),
                tester.birthdate(), tester.sex(), toCommand(tester.measures()));
    }

    private static Set<CreateTesterCommand.Measure> toCommand(Set<Measure> measures) {
        return measures.stream().map(measure -> new CreateTesterCommand.Measure(measure.id(), measure.height(), measure.weight()))
                .collect(Collectors.toSet());
    }

    public record Tester(UUID id, String name, String email, String password, LocalDate birthdate, String sex, Set<Measure> measures) {

    }

    public record Measure(UUID id, Double height, Double weight) {

    }
}
