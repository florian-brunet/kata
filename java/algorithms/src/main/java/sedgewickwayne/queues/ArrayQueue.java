package sedgewickwayne.queues;

public class ArrayQueue<Item> implements Queue<Item> {

    static final int MINIMUM_ARRAY_SIZE = 16;

    public static <T> ArrayQueue<T> newArrayQueue() {
        return new ArrayQueue<T>();
    }

    Item[] items;
    int deqIndex = 0;
    int enqIndex = 0;
    int size = 0;

    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        items = (Item[]) new Object[MINIMUM_ARRAY_SIZE];
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        Item[] newItems = (Item[]) new Object[newSize];
        if (deqIndex < enqIndex) {
            System.arraycopy(items, deqIndex, newItems, 0, enqIndex - deqIndex);
        } else {
            System.arraycopy(items, deqIndex, newItems, 0, items.length - deqIndex);
            System.arraycopy(items, 0, newItems, 0, enqIndex);
        }
        deqIndex = 0;
        enqIndex = size;
        items = newItems;
    }

    @Override
    public void enqueue(Item item) {
        size++;
        items[enqIndex++] = item;
        if (size == items.length) {
            resize(items.length * 2);
        }
        if (enqIndex == items.length) {
            enqIndex = 0;
        }
        items[enqIndex] = item;
    }

    @Override
    public Item dequeue() {
        size--;
        Item item = items[deqIndex];
        items[deqIndex++] = null;
        if (size <= items.length / 4 && items.length > MINIMUM_ARRAY_SIZE) {
            resize(items.length / 2);
        }
        if (deqIndex == items.length) {
            deqIndex = 0;
        }
        return item;
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
