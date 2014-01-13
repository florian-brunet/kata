package sedgewickwayne.priorityqueues;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static sedgewickwayne.sorting.SortingUtils.shuffle;

public class BinaryHeapTest {

    BinaryHeap<Integer> binaryHeap;

    @Before
    public void setUp() throws Exception {
        binaryHeap = BinaryHeap.newBinaryHeap();
    }

    @Test
    public void test() throws Exception {
        Integer[] a = new Integer[100];
        for (int k = 0; k < 100; k++) {
            a[k] = k;
        }
        shuffle(a);
        for (int k = 0; k < 100; k++) {
            binaryHeap.insert(a[k]);
        }
        for (int k = 99; k >= 0; k--) {
            int max = binaryHeap.deleteMax();
            assertEquals("BinaryHeap is broken", k, max);
        }
    }
}
