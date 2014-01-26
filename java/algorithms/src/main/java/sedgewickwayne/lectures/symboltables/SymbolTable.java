package sedgewickwayne.lectures.symboltables;

public interface SymbolTable<Key, Value> {

    /**
     * Puts a key-value pair in a symbol table
     * @param key the key to put in
     * @param value the value to put in
     */
    void put(Key key, Value value);

    /**
     * Gets a value matched with provided key from a symbol table or
     * null if the provided key is not in the symbol table
     * @param key the key to find matched value for
     */
    Value get(Key key);

    /**
     * Deletes a key from a symbol table
     * @param key the key to delete
     */
    void delete(Key key);

    /**
     *Check whether a key is in a table
     * @param key a key to check
     */
    boolean contains(Key key);

    /**
     * Check whether a table is empty
     */
    boolean isEmpty();

    /**
     * Returns symbol table's size
     */
    int size();
}
