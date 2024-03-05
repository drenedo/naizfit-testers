package me.renedo.naizfit.admin.api.http;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import me.renedo.naizfit.admin.E2ETestConfiguration;
import me.renedo.naizfit.testers.application.tester.TesterNotFoundException;
import me.renedo.naizfit.testers.domain.TesterAggregate;
import me.renedo.naizfit.testers.domain.TesterAggregateMother;
import me.renedo.naizfit.testers.domain.TesterAggregateRepository;

@SpringBootTest
@Import(E2ETestConfiguration.class)
class DeleteTesterControllerTest {

    @Autowired
    private DeleteTesterController deleteTesterController;

    @Autowired
    private TesterAggregateRepository testerAggregateRepository;

    @Test
    void should_raise_an_exception_when_deleting_a_non_existing_tester() {
        // Given
        UUID id = UUID.randomUUID();

        // When
        Assertions.assertThrows(TesterNotFoundException.class, () -> deleteTesterController.deleteTesterV1(id));
    }


    @Test
    void should_delete_a_product() {
        // Given
        TesterAggregate testerAggregate = TesterAggregateMother.any();
        testerAggregateRepository.save(testerAggregate);

        // When
        deleteTesterController.deleteTesterV1(testerAggregate.getTesterId());

        // Then
        assertThat(testerAggregateRepository.findById(testerAggregate.getTesterId())).isEmpty();
    }

}
