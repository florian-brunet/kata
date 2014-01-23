package sedgewickwayne.lectures.stacks;

public class LinkedStack<Item> implements Stack<Item> {

    public static <T> LinkedStack<T> newLinkedStack() {
        return new LinkedStack<T>();
    }

    class Node {
        Item item;
        Node next;
    }

    Node first;

    @Override
    public void push(Item item) {
        Node node = new Node();
        node.item = item;
        node.next = first;
        first = node;
    }

    @Override
    public Item pop() {
        Item item = first.item;
        first = first.next;
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
