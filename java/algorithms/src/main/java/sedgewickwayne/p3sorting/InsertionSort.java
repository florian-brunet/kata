package sedgewickwayne.p3sorting;

import static sedgewickwayne.p3sorting.SortingUtils.less;
import static sedgewickwayne.p3sorting.SortingUtils.exchange;

public class InsertionSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
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
