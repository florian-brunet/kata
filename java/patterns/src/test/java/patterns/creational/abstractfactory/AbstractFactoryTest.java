package patterns.creational.abstractfactory;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AbstractFactoryTest {
    @Test
    public void test() throws Exception {

        AbstractFactory factory1 = new ConcreteFactory1();
        AbstractFactory factory2 = new ConcreteFactory2();

        assertEquals(ConcreteProductA1.class, factory1.createProductA().getClass());
        assertEquals(ConcreteProductA2.class, factory2.createProductA().getClass());

        assertEquals(ConcreteProductB1.class, factory1.createProductB().getClass());
        assertEquals(ConcreteProductB2.class, factory2.createProductB().getClass());

    }
}
