package com.coder4.lmsia.commons.indicator.configuration;

import com.coder4.lmsia.commons.indicator.GracefulStatusHealthIndicator;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;

/**
 * @author coder4
 */
@Configuration
@ConditionalOnWebApplication
public class GracefulShutdownHealthIndicatorConfiguration {

    private static final int GRACE_SHUTDOWN_MS = 3000;

    private GracefulStatusHealthIndicator gshIndicator = new GracefulStatusHealthIndicator();

    @Bean
    public HealthIndicator gracefulStatusHealthIndicator() {
        return gshIndicator;
    }

    @PreDestroy
    public void destroy() throws Exception {
        gshIndicator.setReady(false);
        Thread.sleep(GRACE_SHUTDOWN_MS);
    }

}