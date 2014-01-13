package patterns.creational.singleton;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SingletonTest {
    @Test
    public void test() throws Exception {
        LazySingleton instance1 = LazySingleton.getInstance();
        LazySingleton instance2 = LazySingleton.getInstance();
        assertTrue(instance1 == instance2);
    }
}
