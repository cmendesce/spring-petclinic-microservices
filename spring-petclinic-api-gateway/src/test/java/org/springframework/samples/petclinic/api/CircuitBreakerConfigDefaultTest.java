package org.springframework.samples.petclinic.api;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
public class CircuitBreakerConfigDefaultTest {

    @Autowired
    public ApplicationContext context;

    @Test
    public void buildCircuitBreakerConfig_withDefaultValue() {
        var bean = context.getBean(CircuitBreakerConfig.class);
        Assertions.assertThat(bean).usingRecursiveComparison().isEqualTo(CircuitBreakerConfig.ofDefaults());
    }
}
