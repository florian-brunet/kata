package sedgewickwayne.lectures.symboltables;

public class HashTable<Key, Value> implements SymbolTable<Key, Value> {

    static final int MINIMUM_ARRAY_SIZE = 16;

    class Entry<Key, Value> {
        Key key;
        Value value;
        Entry next;
    }

    Entry<Key, Value>[] table;
    int size = 0;

    public static <K,V> HashTable<K,V> newHashTable() {
        return new HashTable<K, V>();
    }

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = (Entry<Key, Value>[]) new Entry[MINIMUM_ARRAY_SIZE];
    }

    @Override
    public void put(Key key, Value value) {
        int hash = hash(key);
        Entry previousEntry = null;
        Entry entry = table[hash];
        while (entry != null) {
            if (entry.key.equals(key)) {
                break;
            }
            previousEntry = entry;
            entry = entry.next;
        }
        if (value == null) {
            if (entry != null) {
                if (previousEntry != null) {
                    previousEntry.next = entry.next;
                } else {
                    table[hash] = entry.next;
                }
                size--;
            }
        } else {
            if (entry == null) {
                entry = new Entry<Key, Value>();
                entry.key = key;
                entry.value = value;
                if (previousEntry == null) {
                    table[hash] = entry;
                } else {
                    previousEntry.next = entry;
                }
                size++;
            } else {
                entry.value = value;
            }
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % table.length;
    }

    @Override
    public Value get(Key key) {
        int hash = hash(key);
        Entry entry = table[hash];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return (Value) entry.value;
            }
            entry = entry.next;
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
