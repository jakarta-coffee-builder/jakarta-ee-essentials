package ${package}.${artifactId.replaceAll("[^a-zA-Z0-9]", "")}.app.resources;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("${apiBasePath}")
public class ApplicationResource extends Application {

}
