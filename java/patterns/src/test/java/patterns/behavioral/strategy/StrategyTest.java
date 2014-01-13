package patterns.behavioral.strategy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StrategyTest {
    @Test
    public void test() throws Exception {

        Strategy add = new AdditionStrategy();
        Strategy multiply = new MultiplicationStrategy();

        Context context = new Context();

        context.setStrategy(add);
        assertEquals(5, context.executeStrategy(2, 3));

        context.setStrategy(multiply);
        assertEquals(6, context.executeStrategy(2, 3));

    }
}
