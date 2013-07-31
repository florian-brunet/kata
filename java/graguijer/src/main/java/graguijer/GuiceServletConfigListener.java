package graguijer;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class GuiceServletConfigListener extends GuiceServletContextListener {
    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
//                serveRegex("/(images|css|jsp)/.*").with(DefaultWrapperServlet.class);
                bind(FreemarkerProvider.class);
                bind(MainController.class);
                serve("/*").with(GuiceContainer.class);
            }
        });
    }
}
