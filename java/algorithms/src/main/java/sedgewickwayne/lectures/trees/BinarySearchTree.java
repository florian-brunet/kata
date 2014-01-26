package sedgewickwayne.lectures.trees;

public class BinarySearchTree<Key extends Comparable<Key>, Value> implements Tree<Key, Value> {

    public static <K extends Comparable<K>, V> BinarySearchTree<K,V> newBinarySearchTree() {
        return new BinarySearchTree<K, V>();
    }

    class Node {

        Key key;
        Value value;
        Node left,right;
        int size;

        private Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }

    }

    Node root;

    @Override
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    Node put(Node node, Key key, Value value) {
        if (node == null) {
            return new Node(key, value, 1);
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult > 0) {
            node.right = put(node.right, key, value);
        } else if (compareResult < 0) {
            node.left = put(node.left, key, value);
        } else {
            node.value = value;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    Value get(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult > 0) {
            return get(node.right, key);
        } else if (compareResult < 0) {
            return get(node.left, key);
        } else {
            return node.value;
        }
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    Node delete(Node node, Key key) {
        if (node == null) {
            return null;
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult > 0) {
            node.right = delete(node.right, key);
        } else if (compareResult < 0) {
            node.left = delete(node.left, key);
        } else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            Node deletedNode = node;
            node = min(node.right);
            node.right = deleteMin(deletedNode.right);
            node.left = deletedNode.left;
        }
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    Node deleteMin(Node node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        return node;
    }

    Node min(Node node) {
        if (node.left == null) {
            return node;
        }
        return min(node);
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        if (root == null) {
            return 0;
        }
        return root.size;
    }

    int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }


}
