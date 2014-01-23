package sedgewickwayne.lectures.sorting;

import static sedgewickwayne.lectures.sorting.SortingUtils.less;
import static sedgewickwayne.lectures.sorting.SortingUtils.merge;

public class MergeSort {

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        if (!less(a[mid+1], a[mid])) {
            return;
        }
        merge(a, aux, lo, mid, hi);
    }

}
