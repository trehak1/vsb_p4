package cz.vsb.p4.testapp;

import cz.atlascon.iqlink.resources.ReadResource;
import cz.atlascon.iqlink.resources.WriteResource;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import io.swagger.jersey.listing.ApiListingResourceJSON;
import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
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

    @Value("${application.port}")
    private int serverPort;
    @Value("${application.context.root}")
    private String contextPath;

    @PostConstruct
    public void registerEndpoints() {
        // jersey
        register(MultiPartFeature.class);
        register(LoggingFilter.class);
        register(ObjectMapperContextResolver.class);
        // app
        register(ReadResource.class);
        register(WriteResource.class);

        // swagger
        register(ApiListingResource.class);
        register(SwaggerSerializers.class);
        register(ApiListingResourceJSON.class);
    }

    @Override
    public void customize(ConfigurableEmbeddedServletContainer containerCfg) {
        containerCfg.setPort(serverPort);
        containerCfg.setContextPath(contextPath);
    }
}

