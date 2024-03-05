package me.renedo.naizfit.testers.api.http;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.test.context.TestSecurityContextHolder;
import org.springframework.security.test.context.support.ReactorContextTestExecutionListener;
import org.springframework.test.context.TestExecutionListener;

import me.renedo.naizfit.testers.api.E2ETestConfiguration;
import me.renedo.naizfit.testers.application.product.ProductNotFoundException;
import me.renedo.naizfit.testers.application.tester.TesterNotFoundException;
import me.renedo.naizfit.testers.domain.ProductAggregate;
import me.renedo.naizfit.testers.domain.ProductAggregateMother;
import me.renedo.naizfit.testers.domain.ProductAggregateRepository;
import me.renedo.naizfit.testers.domain.TestAggregate;
import me.renedo.naizfit.testers.domain.TestAggregateRepository;
import me.renedo.naizfit.testers.domain.TesterAggregate;
import me.renedo.naizfit.testers.domain.TesterAggregateMother;
import me.renedo.naizfit.testers.domain.TesterAggregateRepository;

@SpringBootTest
@Import(E2ETestConfiguration.class)
class PostTestControllerTest {

    @Autowired
    private PostTestController postTestController;

    @Autowired
    private TesterAggregateRepository testerAggregateRepository;

    @Autowired
    private ProductAggregateRepository productAggregateRepository;

    @Autowired
    private TestAggregateRepository testAggregateRepository;

    private final TestExecutionListener reactorContextTestExecutionListener = new ReactorContextTestExecutionListener();

    private final Authentication authentication = Mockito.mock(Authentication.class);
    private final User principal = Mockito.mock(User.class);

    @BeforeEach
    public void setUp() throws Exception {
        doReturn(principal).when(authentication).getPrincipal();
        TestSecurityContextHolder.setAuthentication(authentication);
        reactorContextTestExecutionListener.beforeTestMethod(null);
    }

    @Test
    public void should_raise_tester_not_found_exception() {
        // Given
        UUID uuid = UUID.randomUUID();
        doReturn(uuid.toString()).when(principal).getUsername();

        // When
        assertThrows(TesterNotFoundException.class,
                () -> postTestController.createTestV1(new PostTestController.Test(UUID.randomUUID(), UUID.randomUUID(), "M")).block());
    }

    @Test
    public void should_raise_product_not_found_exception() {
        // Given
        TesterAggregate testerAggregate = TesterAggregateMother.any();
        testerAggregateRepository.save(testerAggregate);
        doReturn(testerAggregate.getTesterId().toString()).when(principal).getUsername();

        // When
        assertThrows(ProductNotFoundException.class,
                () -> postTestController.createTestV1(new PostTestController.Test(UUID.randomUUID(), UUID.randomUUID(), "M")).block());
    }

    @Test
    public void should_be_ok() {
        // Given
        TesterAggregate testerAggregate = TesterAggregateMother.any();
        testerAggregateRepository.save(testerAggregate);
        doReturn(testerAggregate.getTesterId().toString()).when(principal).getUsername();
        ProductAggregate productAggregate = ProductAggregateMother.any();
        productAggregateRepository.save(productAggregate);
        UUID testId = UUID.randomUUID();

        // When
        postTestController.createTestV1(new PostTestController.Test(testId, productAggregate.getProductId(), "M"))
                .block();

        // Then
        Optional<TestAggregate> testAggregate = testAggregateRepository.findById(testId);
        assertThat(testAggregate).isPresent();
    }

    @AfterEach
    public void tearDown() throws Exception {
        reactorContextTestExecutionListener.afterTestMethod(null);
    }

}
