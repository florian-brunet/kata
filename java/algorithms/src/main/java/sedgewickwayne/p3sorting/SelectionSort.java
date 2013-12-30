package sedgewickwayne.p3sorting;

import static sedgewickwayne.p3sorting.SortingUtils.less;
import static sedgewickwayne.p3sorting.SortingUtils.exchange;

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
