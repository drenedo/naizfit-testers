package me.renedo.naizfit.admin.api.http;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import me.renedo.naizfit.admin.E2ETestConfiguration;
import me.renedo.naizfit.testers.application.product.ProductNotFoundException;
import me.renedo.naizfit.testers.domain.ProductAggregate;
import me.renedo.naizfit.testers.domain.ProductAggregateMother;
import me.renedo.naizfit.testers.domain.ProductAggregateRepository;

@SpringBootTest
@Import(E2ETestConfiguration.class)
class DeleteProductControllerTest {

    @Autowired
    private DeleteProductController deleteProductController;

    @Autowired
    private ProductAggregateRepository productAggregateRepository;

    @Test
    void should_raise_an_exception_when_deleting_a_non_existing_product() {
        // Given
        UUID id = UUID.randomUUID();

        // When
        Assertions.assertThrows(ProductNotFoundException.class, () -> deleteProductController.deleteProductV1(id));
    }


    @Test
    void should_delete_a_product() {
        // Given
        ProductAggregate productAggregate = ProductAggregateMother.any();
        productAggregateRepository.save(productAggregate);

        // When
        deleteProductController.deleteProductV1(productAggregate.getProductId());

        // Then
        assertThat(productAggregateRepository.findById(productAggregate.getProductId())).isEmpty();
    }
}
