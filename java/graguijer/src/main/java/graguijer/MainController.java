package graguijer;

import com.google.common.collect.Maps;
import com.google.inject.Singleton;
import com.sun.jersey.api.view.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/")
@Singleton
public class MainController {
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable index() {
        Map<String, Object> model = Maps.newHashMap();
        model.put("string1", "Hello");
        model.put("string2", "World");
        return new Viewable("index", model);
    }
}
