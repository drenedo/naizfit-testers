package me.renedo.naizfit.admin.api.http;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import me.renedo.naizfit.admin.E2ETestConfiguration;
import me.renedo.naizfit.testers.domain.ProductAggregateRepository;

@SpringBootTest
@Import(E2ETestConfiguration.class)
class PostProductControllerTest {

    @Autowired
    private PostProductController postProductController;

    @Autowired
    private ProductAggregateRepository productAggregateRepository;

    @Test
    public void should_persist_product() {
        // Given
        UUID id = UUID.randomUUID();

        // When
        postProductController.createProductV1(
                new PostProductController.Product(id, "any-name", List.of("S", "M"), Set.of("https://google.com"), "Red",
                        new PostProductController.Brand(UUID.randomUUID(), "any-brand", "https://google.com")));

        // Then
        assertThat(productAggregateRepository.findById(id)).isNotEmpty();
    }

    //TODO more test and better assertions
}
