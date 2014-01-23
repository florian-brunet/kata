package sedgewickwayne.lectures.symboltables;

public class UnorderedListTable<Key, Value> implements SymbolTable<Key,Value> {

    public static <K, V> UnorderedListTable<K, V> newUnorderedListTable() {
        return new UnorderedListTable<K, V>();
    }

    class Node {
        Key key;
        Value value;
        Node previous;
        Node next;
    }

    Node first;
    int size = 0;

    @Override
    public void put(Key key, Value value) {
        Node node = getNode(key);
        if (node == null) {
            if (value != null) {
                node = new Node();
                node.key = key;
                node.value = value;
                node.next = first;
                if (node.next != null) {
                    node.next.previous = node;
                }
                first = node;
                size++;
            }
        } else {
            if (value != null) {
                node.key = key;
                node.value = value;
            } else {
                if (node.previous == null) {
                    first = node.next;
                } else {
                    node.previous.next = node.next;
                }
                if (node.next != null) {
                    node.next.previous = node.previous;
                }
                size--;
            }
        }
    }

    private Node getNode(Key key) {
        Node node = first;
        while (node != null) {
            if (node.key.equals(key)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public Value get(Key key) {
        Node node = getNode(key);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        put(key, null);
    }

    @Override
    public boolean contains(Key key) {
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

}
