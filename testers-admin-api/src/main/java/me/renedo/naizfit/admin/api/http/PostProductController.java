package me.renedo.naizfit.admin.api.http;

import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.renedo.naizfit.testers.application.CreateProductCommand;
import me.renedo.naizfit.testers.application.CreateProductUseCase;

@RestController
@Tag(name = "Product", description = "Product API")
public class PostProductController {

    private final CreateProductUseCase createProductUseCase;

    public PostProductController(CreateProductUseCase createProductUseCase) {
        this.createProductUseCase = createProductUseCase;
    }

    @PostMapping(value = "/v1/product")
    @Operation(summary = "Create product", description = "Create product")
    public ResponseEntity<Void> createProductV1(@RequestBody Product product) {
        createProductUseCase.execute(toCommand(product));
        return ResponseEntity.ok().build();
    }

    private CreateProductCommand toCommand(Product product) {
        return new CreateProductCommand(product.id(), product.sku(), product.sizes(), product.pictures(), product.color(),
                toCommand(product.brand()));
    }

    private CreateProductCommand.Brand toCommand(Brand brand) {
        return new CreateProductCommand.Brand(brand.id(), brand.name(), brand.logo());
    }

    public record Product(UUID id, String sku, List<String> sizes, Set<URL> pictures, String color, Brand brand) {

    }

    public record Brand(UUID id, String name, URL logo) {

    }
}
