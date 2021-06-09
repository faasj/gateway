package com.faasj.gateway.initializer;

import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.testcontainers.containers.PostgreSQLContainer;

/**
 * Утилитный клас, содержащий PostgreSQLContainer и класс Initializer.
 * Контейнер создан static, для дальнейшего использования другими тестовыми классами,
 * чтобы не поднимать его каждый раз.
 * <p>
 * Initializer создается для подмены пропертей в контексте на тестовые.
 * Метод apply перетерает существующие значения
 */
@UtilityClass
public class Postgres {

    public static final PostgreSQLContainer<?> CONTAINER = new PostgreSQLContainer<>("postgres:13.3");

    public static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url" + CONTAINER.getJdbcUrl(),
                    "spring.datasource.username" + CONTAINER.getUsername(),
                    "spring.datasource.password" + CONTAINER.getPassword()
            ).applyTo(applicationContext);
        }
    }
}
