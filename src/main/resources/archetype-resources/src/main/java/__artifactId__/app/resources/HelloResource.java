package ${package}.${artifactId}.app.resources;

import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("hello")
public class HelloResource {

    @GET
    public Response hello(@QueryParam("name") @DefaultValue("world") String name) {
        var message = "Hello %s".formatted(name);
        return Response.ok(message).build();
    }
}
