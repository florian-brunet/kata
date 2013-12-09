package example1;

import example1.objects.Object1;
import example1.objects.Object2;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;

/**
 * @author dmitriy.kurkin
 */
public class Example1 {

    public static void main(String[] args) {

        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(Object1.class, Object2.class);
            }
        });

        Object1 object1 = new Object1("some", "some_other", 42);
        System.out.println("Initial object: ["+object1+"]");

        Object2 object2 = mapper.map(object1, Object2.class);
        System.out.println("Mapped object: ["+object2+"]");

        object2.setInteger(43);
        System.out.println("Changed object: ["+object2+"]");

        mapper.map(object2, object1);
        System.out.println("Mapped back object: ["+object1+"]");

    }

}
