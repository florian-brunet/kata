package osgicxf;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author deemson
 *         created on 9/3/13
 */
@WebService
@Produces(MediaType.TEXT_PLAIN)
public interface IHelloWorldService {
    @GET
    @Path("/")
    String sayHello();
}
