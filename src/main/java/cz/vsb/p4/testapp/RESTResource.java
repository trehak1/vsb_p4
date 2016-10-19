package cz.vsb.p4.testapp;

import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by trehak on 10.10.2016.
 */
@Path("/counter")
@Produces("application/json")
public class RESTResource {

    private final CounterService counterService;

    @Autowired
    public RESTResource(CounterService counterService) {
        this.counterService = counterService;
    }

    @GET
    @Path("/inc/{key}")
    public CounterValue getAndIncrementCounterValue(@PathParam("key") String key) {
        return counterService.getAndIncrement(key);
    }

    @GET
    @Path("/echo/{text}")
    public String echo(@PathParam("text") String text) {
        return text;
    }


}
