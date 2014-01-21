package sedgewickwayne.symboltables;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class OrderedArrayTableTest {

    OrderedArrayTable<Integer, Integer> table;

    @Before
    public void setUp() throws Exception {
        table = OrderedArrayTable.newOrderedArrayTable();
    }

    private <T> void checkEquality(List<T> list, T[] array) {
        int size = list.size();
        assertEquals(list, Arrays.asList(Arrays.copyOf(array, size)));
        for (int k = size; k < array.length; k++) {
            assertNull("too many elements in the array - a["+k+"]:", array[k]);
        }
    }

    @Test
    public void testPutAndDeleteWithoutResizingArray() throws Exception {

        table.delete(1);
        assertEquals("table size modified after the deletion of non-existent key",0, table.size);

        table.put(1, 10);
        table.put(2, 20);
        table.put(4, 40);
        checkEquality(Lists.newArrayList(1, 2, 4), table.keys);
        checkEquality(Lists.newArrayList(10, 20, 40), table.values);
        table.put(3, 30);
        checkEquality(Lists.newArrayList(1, 2, 3, 4), table.keys);
        checkEquality(Lists.newArrayList(10, 20, 30, 40), table.values);
        table.put(5, 50);
        checkEquality(Lists.newArrayList(1, 2, 3, 4, 5), table.keys);
        checkEquality(Lists.newArrayList(10, 20, 30, 40, 50), table.values);

        table.delete(5);
        checkEquality(Lists.newArrayList(1, 2, 3, 4), table.keys);
        checkEquality(Lists.newArrayList(10, 20, 30, 40), table.values);
        table.delete(3);
        checkEquality(Lists.newArrayList(1, 2, 4), table.keys);
        checkEquality(Lists.newArrayList(10, 20, 40), table.values);

        table.put(4, 30);
        checkEquality(Lists.newArrayList(1, 2, 4), table.keys);
        checkEquality(Lists.newArrayList(10, 20, 30), table.values);

    }

    private <T> List<T> addToList(List<T> list, T... entries) {
        List<T> newList = Lists.newArrayList();
        newList.addAll(list);
        newList.addAll(Arrays.asList(entries));
        return newList;
    }

    @Test
    public void testPutAndDeleteWithArrayResizing() throws Exception {

        List<Integer> refList = Lists.newArrayList();
        for (int k = 0; k < OrderedArrayTable.MINIMUM_ARRAY_SIZE; k++) {
            table.put(k, k);
            refList.add(k);
        }
        table.put(101, 10);
        checkEquality(addToList(refList, 101), table.keys);
        checkEquality(addToList(refList, 10), table.values);
        table.delete(101);
        for (int k = OrderedArrayTable.MINIMUM_ARRAY_SIZE-1; k >= 4; k--) {
            table.delete(k);
        }
        assertEquals("table hasn't shrunk", OrderedArrayTable.MINIMUM_ARRAY_SIZE, Arrays.asList(table.keys).size());

    }
      
}
