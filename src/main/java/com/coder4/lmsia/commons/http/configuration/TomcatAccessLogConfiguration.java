package com.coder4.lmsia.commons.http.configuration;

import org.apache.catalina.valves.AccessLogValve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author coder4
 */
@Configuration
@ConditionalOnWebApplication
public class TomcatAccessLogConfiguration
        extends WebMvcConfigurerAdapter implements EmbeddedServletContainerCustomizer {

    private Logger LOG = LoggerFactory.getLogger(getClass());

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        if (container instanceof TomcatEmbeddedServletContainerFactory) {
            TomcatEmbeddedServletContainerFactory factory = (TomcatEmbeddedServletContainerFactory) container;
            AccessLogValve accessLogValve = new AccessLogValve();
            accessLogValve.setEnabled(true);
            accessLogValve.setDirectory("/app/logs/");
            accessLogValve.setPattern("common");
            accessLogValve.setSuffix(".log");
            factory.addContextValves(accessLogValve);
        } else {
            LOG.error("This customizer does not support your configured container!");
        }
    }
}