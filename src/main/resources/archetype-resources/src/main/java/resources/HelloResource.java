package ${package}.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("hello")
public class HelloResource {

    @Inject
    @ConfigProperty(name = "property.value")
    private String greeting;

    @GET
    public Response hello(@QueryParam("name") @DefaultValue("world") String name) {
        var message = greeting.formatted(name);
        return Response.ok(message).build();
    }
}
