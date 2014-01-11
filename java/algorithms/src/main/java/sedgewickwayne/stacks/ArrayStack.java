package sedgewickwayne.stacks;

public class ArrayStack<Item> implements Stack<Item> {

    static final int MINIMUM_ARRAY_SIZE = 16;

    public static <T> ArrayStack<T> newArrayStack() {
        return new ArrayStack<T>();
    }

    int size = 0;
    Item[] items;

    @SuppressWarnings("unchecked")
    public ArrayStack() {
        items = (Item[]) new Object[MINIMUM_ARRAY_SIZE];
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        Item[] newItems = (Item[]) new Object[newSize];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    @Override
    public void push(Item item) {
        if (size == items.length) {
            resize(items.length * 2);
        }
        items[size++] = item;
    }

    @Override
    public Item pop() {
        Item item = items[--size];
        items[size] = null;
        if (size <= items.length / 4 && items.length > MINIMUM_ARRAY_SIZE) {
            resize(items.length / 2);
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
