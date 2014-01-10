package sedgewickwayne.utils;

public class ArrayUtils {

    @SuppressWarnings("unchecked")
    public static <Item> Item[] resize(Item[] oldItems, int size, int elementsToCopy) {
        Item[] items = (Item[]) new Object[size];
        System.arraycopy(oldItems, 0, items, 0, elementsToCopy);
        return items;
    }

}
