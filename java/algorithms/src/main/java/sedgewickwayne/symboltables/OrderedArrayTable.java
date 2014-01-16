package sedgewickwayne.symboltables;

import java.util.Arrays;

public class OrderedArrayTable<Key extends Comparable<Key>, Value> implements SymbolTable<Key,Value> {

    static final int MINIMUM_ARRAY_SIZE = 16;

    public static <K extends Comparable<K>, V> OrderedArrayTable<K, V> newOrderedArrayTable() {
        return new OrderedArrayTable<K, V>();
    }

    int size = 0;
    Key[] keys;
    Value[] values;

    @SuppressWarnings("unchecked")
    public OrderedArrayTable() {
        keys = (Key[]) new Comparable[MINIMUM_ARRAY_SIZE];
        values = (Value[]) new Object[MINIMUM_ARRAY_SIZE];
    }

    @Override
    @SuppressWarnings("unchecked")
    public void put(Key key, Value value) {
        int rank = rank(key);
        if (value == null) {
            if (keys[rank] == null || key.compareTo(keys[rank]) != 0) {
                return;
            }
            if (rank == size-1) {
                keys[rank] = null;
                values[rank] = null;
                size--;
            } else {
                System.arraycopy(keys, rank+1, keys, rank, size-rank);
                System.arraycopy(values, rank+1, values, rank, size-rank);
                size--;
                keys[size] = null;
                values[size] = null;
            }
            if (size <= keys.length / 4 && keys.length > MINIMUM_ARRAY_SIZE) {
                int newLength = keys.length / 2;
                Key[] newKeys = (Key[]) new Comparable[newLength];
                Value[] newValues = (Value[]) new Object[newLength];
                System.arraycopy(keys, 0, newKeys, 0, size);
                System.arraycopy(values, 0, newValues, 0, size);
                keys = newKeys;
                values = newValues;
            }
        } else {
            if (rank <= size-1 && key.compareTo(keys[rank]) != 0) {
                System.arraycopy(keys, rank, keys, rank+1, size-rank);
                System.arraycopy(values, rank, values, rank+1, size-rank);
                size++;
            } else if (rank > size-1) {
                size++;
            }
            keys[rank] = key;
            values[rank] = value;
            if (size == keys.length) {
                int newLength = 2 * keys.length;
                Key[] newKeys = (Key[]) new Comparable[newLength];
                Value[] newValues = (Value[]) new Object[newLength];
                System.arraycopy(keys, 0, newKeys, 0, size);
                System.arraycopy(values, 0, newValues, 0, size);
                keys = newKeys;
                values = newValues;
            }
        }
    }

    private int rank(Key key) {
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int comparison = key.compareTo(keys[mid]);
            if (comparison > 0) {
                lo = mid + 1;
            } else if (comparison < 0) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    @Override
    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int rank = rank(key);
        if (rank < size && keys[rank].compareTo(key) == 0) {
            return values[rank];
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
