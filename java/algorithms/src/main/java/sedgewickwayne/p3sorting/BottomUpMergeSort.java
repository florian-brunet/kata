package sedgewickwayne.p3sorting;

import static sedgewickwayne.p3sorting.SortingUtils.merge;

public class BottomUpMergeSort {

    public static void sort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[a.length];
        for (int size = 1; size < N; size = size + size) {
            for (int lo = 0; lo < N-size; lo += size+size) {
                merge(a, aux, lo, lo+size-1, Math.min(lo+size+size-1, N-1));
            }
        }
    }

}
