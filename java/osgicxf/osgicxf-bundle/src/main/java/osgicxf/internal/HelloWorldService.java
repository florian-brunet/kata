package osgicxf.internal;

import osgicxf.IHelloWorldService;

/**
 * @author deemson
 *         created on 9/3/13
 */
public class HelloWorldService implements IHelloWorldService {

    public HelloWorldService() {
        System.out.println(HelloWorldService.class.getName()+" is up and running");
    }

    @Override
    public String sayHello() {
        return "Hello World from "+HelloWorldService.class.getSimpleName();
    }

}
