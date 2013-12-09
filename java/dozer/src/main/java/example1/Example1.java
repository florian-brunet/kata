package example1;

import example1.objects.Object1;
import example1.objects.Object2;
import org.dozer.DozerBeanMapper;

public class Example1 {

    public static void main(String[] args) {

        DozerBeanMapper mapper = new DozerBeanMapper();

        Object1 object1 = new Object1("some", "some_other", 42);
        System.out.println("\tInitial object: ["+object1+"]");

        Object2 object2 = mapper.map(object1, Object2.class);
        System.out.println("\tMapped object: ["+object2+"]");

        object2.setInteger(43);
        System.out.println("\tChanged object: ["+object2+"]");

        mapper.map(object2, object1);
        System.out.println("\tMapped back object: ["+object1+"]");

    }

}
