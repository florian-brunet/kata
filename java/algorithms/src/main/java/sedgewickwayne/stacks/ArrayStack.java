package sedgewickwayne.stacks;

import static sedgewickwayne.utils.ArrayUtils.resize;

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

    @Override
    public void push(Item item) {
        if (size == items.length) {
            items = resize(items, items.length * 2, size);
        }
        items[size++] = item;
    }

    @Override
    public Item pop() {
        Item item = items[--size];
        items[size] = null;
        if (size <= items.length / 4 && items.length > MINIMUM_ARRAY_SIZE) {
            items = resize(items, items.length / 2, size);
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
