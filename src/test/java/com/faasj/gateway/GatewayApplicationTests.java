package com.faasj.gateway;

import com.faasj.gateway.initializer.Postgres;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@Sql("/sql/data.sql")
@SpringBootTest
@ContextConfiguration(initializers = {
        Postgres.Initializer.class
})
@Transactional
@ActiveProfiles("test")
public abstract class GatewayApplicationTests {

    @BeforeAll
    static void init() {
        Postgres.CONTAINER.start();
    }
}
