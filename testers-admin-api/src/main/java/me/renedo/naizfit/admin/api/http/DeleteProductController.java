package me.renedo.naizfit.admin.api.http;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.renedo.naizfit.testers.application.DeleteProductCommand;
import me.renedo.naizfit.testers.application.DeleteProductUseCase;

@RestController
@Tag(name = "Product", description = "Product API")
public class DeleteProductController {

    private final DeleteProductUseCase deleteProductUseCase;

    public DeleteProductController(DeleteProductUseCase deleteProductUseCase) {
        this.deleteProductUseCase = deleteProductUseCase;
    }


    @DeleteMapping(value = "/v1/product/{id}")
    @Operation(summary = "Delete product by id", description = "Delete product")
    public ResponseEntity<Void> deleteProductV1(@PathVariable("id") UUID id) {
        deleteProductUseCase.execute(new DeleteProductCommand(id));
        return ResponseEntity.ok().build();
    }
}
