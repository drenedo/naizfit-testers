package me.renedo.naizfit.testers.api.http;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.renedo.naizfit.testers.application.CreateTestCommand;
import me.renedo.naizfit.testers.application.CreateTestUseCase;

@RestController
@Tag(name = "Test", description = "Test API")
public class PostTestController {

    private final CreateTestUseCase createTestUseCase;

    public PostTestController(CreateTestUseCase createTestUseCase) {
        this.createTestUseCase = createTestUseCase;
    }

    @PostMapping(value = "/v1/tester")
    @Operation(summary = "Create tester", description = "Create tester")
    public ResponseEntity<Void> createTestV1(@RequestBody Test test) {
        createTestUseCase.execute(toCommand(test));
        return ResponseEntity.ok().build();
    }

    private CreateTestCommand toCommand(Test test) {
        return new CreateTestCommand(test.id(), null, test.productId(), test.size());
    }

    public record Test(UUID id, UUID productId, String size) {

    }
}
