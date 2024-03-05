package me.renedo.naizfit.admin.api.http;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.renedo.naizfit.testers.application.tester.DeleteTesterCommand;
import me.renedo.naizfit.testers.application.tester.DeleteTesterUseCase;

@RestController
@Tag(name = "Tester", description = "Tester API")
public class DeleteTesterController {

    private final DeleteTesterUseCase deleteTesterUseCase;

    public DeleteTesterController(DeleteTesterUseCase deleteTesterUseCase) {
        this.deleteTesterUseCase = deleteTesterUseCase;
    }


    @DeleteMapping(value = "/v1/tester/{id}")
    @Operation(summary = "Delete tester by id", description = "Delete product")
    public ResponseEntity<Void> deleteTesterV1(@PathVariable("id") UUID id) {
        deleteTesterUseCase.execute(new DeleteTesterCommand(id));
        return ResponseEntity.ok().build();
    }
}
