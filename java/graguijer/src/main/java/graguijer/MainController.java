package graguijer;

import com.google.inject.Singleton;
import com.sun.jersey.api.view.Viewable;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Singleton
public class MainController {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable login() {
        return new Viewable("login");
    }

}
