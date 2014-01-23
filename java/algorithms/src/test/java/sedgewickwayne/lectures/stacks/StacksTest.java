package sedgewickwayne.lectures.stacks;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StacksTest {

    List<Stack<Integer>> stacks;

    @Before
    public void setUp() throws Exception {
        stacks = Lists.newArrayList();
        stacks.add(LinkedStack.<Integer>newLinkedStack());
        stacks.add(ArrayStack.<Integer>newArrayStack());
    }

    @Test
    public void testStacks() throws Exception {
        for (Stack<Integer> stack : stacks) {
            String name = stack.getClass().getSimpleName();
            assertTrue(name + ".isEmpty does not work", stack.isEmpty());
            assertEquals(name + ".size does not work", 0, stack.size());
            for (int k = 0; k < 100; k++) {
                stack.push(k);
                assertFalse(name+".isEmpty or "+name+ ".push does not work", stack.isEmpty());
                assertEquals(name+".size or "+name+ ".push does not work", k+1, stack.size());
            }
            for (int k = 100; k > 0; k--) {
                assertEquals(name+".pop does not work", new Integer(k-1), stack.pop());
                assertEquals(name+".size or "+name+ ".pop does not work", k-1, stack.size());
            }
            assertEquals(name+".size or "+name+ ".pop does not work", 0, stack.size());
            assertTrue(".isEmpty does not work", stack.isEmpty());
        }
    }

}
