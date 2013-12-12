package camel.example1;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Example1 {

    public static void main(String[] args) throws Exception {

        RouteBuilder routeBuilder = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("asd")
                        .to("asd")
                        .to("dsa");
            }
        };
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(routeBuilder);

        camelContext.start();

    }

}
