package patterns.creational.abstractfactory;

public class Example {

    public static void main(String[] args) {

        AbstractFactory factory1 = new ConcreteFactory1();
        AbstractFactory factory2 = new ConcreteFactory2();

        System.out.println(factory1.createProductA().getClass().getSimpleName());
        System.out.println(factory1.createProductB().getClass().getSimpleName());
        System.out.println(factory2.createProductA().getClass().getSimpleName());
        System.out.println(factory2.createProductB().getClass().getSimpleName());

    }

}
