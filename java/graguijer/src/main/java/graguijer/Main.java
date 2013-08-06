package graguijer;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

        WebAppContext webAppContext = new WebAppContext("web", "/");
        webAppContext.setResourceBase("web");

        Server server = new Server(8080);
        server.setHandler(webAppContext);
        server.start();
        server.join();

    }
}
