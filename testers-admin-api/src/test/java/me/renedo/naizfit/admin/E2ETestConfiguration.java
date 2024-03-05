package me.renedo.naizfit.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

import me.renedo.naizfit.AdminApiApplication;

@TestConfiguration(proxyBeanMethods = false)
public class E2ETestConfiguration {

    private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>(DockerImageName.parse("postgres:latest"))
            .withInitScript("test-schema.sql")
            .withDatabaseName("naizfit")
            .withUsername("naizfit")
            .withPassword("naizfit")
            .withReuse(true);

    public static void main(String[] args) {
        SpringApplication.from(AdminApiApplication::main).with(AdminApiApplication.class).run(args);
    }

    @Bean
    @ServiceConnection
    PostgreSQLContainer<?> postgresContainer() {
        return postgres;
    }

    @DynamicPropertySource
    static void datasourceProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }
}
