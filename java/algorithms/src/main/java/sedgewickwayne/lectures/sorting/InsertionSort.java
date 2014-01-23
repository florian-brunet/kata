package sedgewickwayne.lectures.sorting;

import static sedgewickwayne.lectures.sorting.SortingUtils.exchange;
import static sedgewickwayne.lectures.sorting.SortingUtils.less;

public class InsertionSort {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length-1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) {
                    exchange(a, j-1, j);
                } else {
                    break;
                }
            }
        }
    }



}
