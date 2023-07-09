package org.springframework.samples.petclinic.api;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
public class CircuitBreakerConfigParameterizedTest {

    @Autowired
    public ApplicationContext context;

    @BeforeAll
    public static void beforeClass() {
        System.setProperty("failureRateThreshold", "10");
    }

    @Test
    public void buildCircuitBreakerConfig_withNonDefaultValues() {
        var bean = context.getBean(CircuitBreakerConfig.class);
        Assertions.assertThat(bean.getFailureRateThreshold()).isEqualTo(10f);
    }
}
