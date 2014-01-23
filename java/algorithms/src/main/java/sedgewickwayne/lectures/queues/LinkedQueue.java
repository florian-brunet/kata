package sedgewickwayne.lectures.queues;

public class LinkedQueue<Item> implements Queue<Item> {

    public static <T> LinkedQueue<T> newLinkedQueue() {
        return new LinkedQueue<T>();
    }

    class Node {
        Item item;
        Node next;
    }

    Node first;
    Node last;

    @Override
    public void enqueue(Item item) {
        Node node = new Node();
        node.item = item;
        if (last != null) {
            last.next = node;
        } else {
            first = node;
        }
        last = node;
    }

    @Override
    public Item dequeue() {
        Item item = first.item;
        first = first.next;
        if (first == null) {
            last = null;
        }
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        Node node = first;
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }
}
