package com.faasj.gateway;

import com.faasj.gateway.initializer.Postgres;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = {
        Postgres.Initializer.class
})
class GatewayApplicationTests {

    @BeforeAll
    static void init() {
        Postgres.CONTAINER.start();
    }

    @Test
    void contextLoads() {
    }

}
