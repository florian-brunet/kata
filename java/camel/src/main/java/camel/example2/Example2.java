package camel.example2;

import com.google.common.collect.Maps;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class Example2 {

    public static void main(String[] args) {


        ClassPathXmlApplicationContext camelAppCtx
                = new ClassPathXmlApplicationContext("camel/example2/example2-spring-context.xml");
        Map<String, Object> params = Maps.newHashMap();
        params.put("param1", "turum");
        params.put("param2", "burum");
        CamelProxy camelProxy = camelAppCtx.getBean(CamelProxy.class);
        System.out.println("response: " + camelProxy.runRoute(params));

    }

}
