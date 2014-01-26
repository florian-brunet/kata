package sedgewickwayne.lectures.sorting;

import static sedgewickwayne.lectures.sorting.SortingUtils.exchange;
import static sedgewickwayne.lectures.sorting.SortingUtils.isSorted;
import static sedgewickwayne.lectures.sorting.SortingUtils.less;

public class HeapSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int k = N/2; k >= 1; k--) {
            sink(a, k, N);
        }
        while (N > 1) {
            exchange(a, 0, N-1);
            sink(a, 1, --N);
        }
        assert isSorted(a);
    }

    private static void sink(Comparable[] a, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(a[j-1], a[j])) {
                j++;
            }
            if (!less(a[k-1],a[j-1])) {
                break;
            }
            exchange(a, k-1, j-1);
            k = j;
        }
    }

}
