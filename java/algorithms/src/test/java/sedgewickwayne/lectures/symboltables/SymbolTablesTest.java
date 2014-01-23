package sedgewickwayne.lectures.symboltables;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sedgewickwayne.lectures.sorting.SortingUtils;

import java.util.List;

import static org.junit.Assert.*;

public class SymbolTablesTest {

    private final static Logger LOGGER = LoggerFactory.getLogger(SymbolTablesTest.class);

    List<SymbolTable<Integer, Integer>> symbolTables;

    @Before
    public void setUp() throws Exception {
        symbolTables = Lists.newArrayList();
        symbolTables.add(UnorderedListTable.<Integer, Integer>newUnorderedListTable());
        symbolTables.add(OrderedArrayTable.<Integer, Integer>newOrderedArrayTable());
        symbolTables.add(HashTable.<Integer, Integer>newHashTable());
    }

    @Test
    public void test() throws Exception {
        for (SymbolTable<Integer, Integer> symbolTable : symbolTables) {
            String name = symbolTable.getClass().getSimpleName();
            assertTrue(name + ".isEmpty does not work", symbolTable.isEmpty());
            assertEquals(name + ".size does not work", 0, symbolTable.size());

            for (int k = 0; k<100; k++) {

                LOGGER.debug("Inserting key = " + k);
                assertFalse(name + ".contains does not work", symbolTable.contains(k));
                symbolTable.put(k, k);
                assertTrue(name + ".contains does not work", symbolTable.contains(k));

                symbolTable.put(100, 10);
                assertFalse(name + ".isEmpty does not work", symbolTable.isEmpty());
                assertEquals(name + ".size does not work", k+2, symbolTable.size());
                assertEquals(name + ".get does not work", new Integer(10), symbolTable.get(100));

                symbolTable.put(101, 20);
                assertFalse(name + ".isEmpty does not work", symbolTable.isEmpty());
                assertEquals(name + ".size does not work", k+3, symbolTable.size());
                assertEquals(name + ".get does not work", new Integer(10), symbolTable.get(100));
                assertEquals(name + ".get does not work", new Integer(20), symbolTable.get(101));

                symbolTable.put(100, 30);
                assertFalse(name + ".isEmpty does not work", symbolTable.isEmpty());
                assertEquals(name + ".size does not work", k+3, symbolTable.size());
                assertEquals(name + ".get does not work", new Integer(30), symbolTable.get(100));
                assertEquals(name + ".get does not work", new Integer(20), symbolTable.get(101));

                symbolTable.delete(100);
                assertFalse(name + ".isEmpty does not work", symbolTable.isEmpty());
                assertEquals(name + ".size does not work", k+2, symbolTable.size());
                assertEquals(name + ".get does not work", null, symbolTable.get(100));
                assertEquals(name + ".get does not work", new Integer(20), symbolTable.get(101));

                symbolTable.delete(101);
                assertEquals(name + ".size or " + name + ".delete does not work", k+1, symbolTable.size());
            }

            Integer[] order = new Integer[100];
            for (int k = 0; k<100; k++) {
                order[k] = k;
            }
            SortingUtils.shuffle(order);
            for (int k = 99; k>=0; k--) {
                assertTrue(name + ".contains does not work", symbolTable.contains(order[k]));
                LOGGER.debug("Deleting key = " + order[k]);
                symbolTable.delete(order[k]);
                assertEquals(name + ".delete does not work", k, symbolTable.size());
                assertFalse(name + ".contains does not work", symbolTable.contains(order[k]));
            }

            assertEquals(name + ".size or " + name + ".delete does not work", 0, symbolTable.size());
            assertTrue(".isEmpty does not work", symbolTable.isEmpty());
        }
    }

}
