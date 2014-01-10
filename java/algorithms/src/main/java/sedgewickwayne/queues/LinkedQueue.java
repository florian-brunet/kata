package sedgewickwayne.queues;

public class LinkedQueue<Item> implements Queue<Item> {

    class Node {
        Item item;
        Node previous;
    }

    Node last;

    @Override
    public void enqueue(Item item) {

    }

    @Override
    public Item dequeue() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
