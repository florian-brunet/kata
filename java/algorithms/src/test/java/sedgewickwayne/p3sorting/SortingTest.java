package sedgewickwayne.p3sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SortingTest {

    private Integer[] a;

    @Before
    public void setUp() throws Exception {
        a = new Integer[]{5, 9, 6, 1 ,8, 2, 3, 12, 3, 2, 6, 8, 5, 4, 0, 2};
    }

    @Test
    public void testSelectionSort() throws Exception {
        SelectionSort.sort(a);
        assertTrue("Unsorted array: "+ Arrays.asList(a),SortingUtils.isSorted(a));
    }

    @Test
    public void testInsertionSort() throws Exception {
        InsertionSort.sort(a);
        assertTrue("Unsorted array: "+ Arrays.asList(a),SortingUtils.isSorted(a));
    }

    @Test
    public void testShellSort() throws Exception {
        ShellSort.sort(a);
        assertTrue("Unsorted array: "+ Arrays.asList(a),SortingUtils.isSorted(a));
    }

    @Test
    public void testMergeSort() throws Exception {
        MergeSort.sort(a);
        assertTrue("Unsorted array: "+ Arrays.asList(a),SortingUtils.isSorted(a));
    }

    @Test
    public void testBottomUpMergeSort() throws Exception {
        BottomUpMergeSort.sort(a);
        assertTrue("Unsorted array: "+ Arrays.asList(a),SortingUtils.isSorted(a));
    }

}
