package sedgewickwayne.lectures.sorting;

import static sedgewickwayne.lectures.sorting.SortingUtils.exchange;
import static sedgewickwayne.lectures.sorting.SortingUtils.less;

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
