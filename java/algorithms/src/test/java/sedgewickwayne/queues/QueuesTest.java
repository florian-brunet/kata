package sedgewickwayne.queues;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class QueuesTest {
    
    List<Queue<Integer>> queues;

    @Before
    public void setUp() throws Exception {
        queues = Lists.newArrayList();
        queues.add(LinkedQueue.<Integer>newLinkedQueue());
        queues.add(ArrayQueue.<Integer>newArrayQueue());
    }

    @Test
    public void testQueues() throws Exception {
        for (Queue<Integer> queue : queues) {
            String name = queue.getClass().getSimpleName();
            assertTrue(name + ".isEmpty does not work", queue.isEmpty());
            assertEquals(name + ".size does not work", 0, queue.size());
            for (int k = 0; k < 100; k++) {
                queue.enqueue(k);
                assertFalse(name+".isEmpty or "+name+ ".enqueue does not work", queue.isEmpty());
                assertEquals(name+".size or "+name+ ".enqueue does not work", k+1, queue.size());
            }
            for (int k = 0; k < 100; k++) {
                assertEquals(name+".dequeue does not work", new Integer(k), queue.dequeue());
                assertEquals(name+".size or "+name+ ".dequeue does not work", 99-k, queue.size());
            }
            assertEquals(name+".size or "+name+ ".dequeue does not work", 0, queue.size());
            assertTrue(".isEmpty does not work", queue.isEmpty());
        }
    }
}
