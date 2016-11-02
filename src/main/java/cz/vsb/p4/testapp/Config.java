package cz.vsb.p4.testapp;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;


/**
 * Created by trehak on 11.3.2016.
 */

@Component
@ApplicationPath("/rest")
public class Config extends ResourceConfig implements EmbeddedServletContainerCustomizer {

    @Value("${application.port:8080}")
    private int serverPort;
    @Value("${application.context.root:}")
    private String contextPath;

    @PostConstruct
    public void registerEndpoints() {
        // jersey
        register(LoggingFilter.class);
        register(StromRESTResource.class);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer containerCfg) {
        containerCfg.setPort(serverPort);
        containerCfg.setContextPath(contextPath);
    }
}

