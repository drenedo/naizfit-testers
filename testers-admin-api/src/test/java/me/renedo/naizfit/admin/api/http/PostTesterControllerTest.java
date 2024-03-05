package me.renedo.naizfit.admin.api.http;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import me.renedo.naizfit.admin.E2ETestConfiguration;
import me.renedo.naizfit.testers.domain.TesterAggregateRepository;

@SpringBootTest
@Import(E2ETestConfiguration.class)
class PostTesterControllerTest {

    @Autowired
    private PostTesterController postTesterController;

    @Autowired
    private TesterAggregateRepository testerAggregateRepository;

    @Test
    public void should_persist_product() {
        // Given
        UUID id = UUID.randomUUID();

        // When
        postTesterController.createTesterV1(
                new PostTesterController.Tester(id, "any-name", "tester@naiz.fit", "tester", LocalDate.now().minusYears(12),
                        "MALE", Set.of(new PostTesterController.Measure(UUID.randomUUID(), 23.45D, 45.67D))));

        // Then
        assertThat(testerAggregateRepository.findById(id)).isNotEmpty();
    }

    //TODO more test and better assertions
}
