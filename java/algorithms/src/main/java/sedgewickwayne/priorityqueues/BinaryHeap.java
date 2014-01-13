package sedgewickwayne.priorityqueues;

import static sedgewickwayne.sorting.SortingUtils.exchange;
import static sedgewickwayne.sorting.SortingUtils.less;

public class BinaryHeap<Item extends Comparable<Item>> {

    static final int MINIMUM_ARRAY_SIZE = 16;

    public static <T extends Comparable<T>> BinaryHeap<T> newBinaryHeap() {
        return new BinaryHeap<T>();
    }

    private Item[] items;

    private int size = 0;

    @SuppressWarnings("unchecked")
    public BinaryHeap() {
        items = (Item[]) new Comparable[MINIMUM_ARRAY_SIZE];
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {
        Item[] newItems = (Item[]) new Comparable[newSize];
        System.arraycopy(items, 0, newItems, 0, size+1);
        items = newItems;
    }

    public void insert(Item item) {
        if (size+1 == items.length) {
            resize(items.length * 2);
        }
        items[++size] = item;
        swim(size);
    }

    public Item deleteMax() {
        Item item = items[1];
        exchange(items, 1, size--);
        sink(1);
        items[size+1] = null;
        if (size <= items.length / 4 && items.length > MINIMUM_ARRAY_SIZE) {
            resize(items.length / 2);
        }
        return item;
    }

    private void swim(int k) {
        while (k > 1 && less(items[k/2], items[k])) {

                exchange(items, k/2, k);

            k = k/2;
        }
    }

    private void sink(int k) {
        while (2*k <= size) {
            int j = 2*k;
            if (j < size && less(items[j], items[j+1])) {
                j++;
            }
            if (!less(items[k],items[j])) {
                break;
            }
            exchange(items, k, j);
            k = j;
        }
    }

}
