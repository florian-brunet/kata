package sedgewickwayne.lectures.trees;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class BinarySearchTreeTest {

    BinarySearchTree<Integer, Integer> bst;

    @Before
    public void setUp() throws Exception {
        bst = BinarySearchTree.newBinarySearchTree();
    }

    @Test
    public void test1() throws Exception {
        bst.put(5, 5);
        checkNode(bst.root, 5, 5, 1);
        bst.put(2, 2);
        checkNode(bst.root, 5, 5, 2);
        checkNode(bst.root.left, 2, 2, 1);
        bst.delete(5);
        checkNode(bst.root, 2, 2, 1);
    }

    @Test
    public void test2() throws Exception {
        bst.put(5, 5);
        checkNode(bst.root, 5, 5, 1);
        bst.put(7, 7);
        checkNode(bst.root, 5, 5, 2);
        checkNode(bst.root.right, 7, 7, 1);
        bst.delete(5);
        checkNode(bst.root, 7, 7, 1);
    }

    @Test
    public void test3() throws Exception {
        bst.put(5, 5);
        checkNode(bst.root, 5, 5, 1);
        bst.put(2, 2);
        bst.put(7, 7);
        checkNode(bst.root, 5, 5, 3);
        checkNode(bst.root.left, 2, 2, 1);
        checkNode(bst.root.right, 7, 7, 1);
        bst.delete(5);
        assertFalse("tree contains deleted key", bst.contains(5));
        assertEquals("wrong tree size after deletion", 2, bst.root.size);
    }

    private void checkNode(BinarySearchTree.Node node, Integer key, Integer value, int size) {
        assertEquals("wrong key", key, node.key);
        assertEquals("wrong value", value, node.value);
        assertEquals("wrong size", size, node.size);
    }

}
