package sedgewickwayne.sorting;

import static sedgewickwayne.sorting.SortingUtils.exchange;
import static sedgewickwayne.sorting.SortingUtils.less;

public class SelectionSort {

    public static void sort(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i; j < a.length; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }

}
