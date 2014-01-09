package sedgewickwayne.p3sorting;

import sedgewickwayne.utils.StdRandom;

public class SortingUtils {

    public static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    public static void exchange(Object[] objects, int i, int j) {
        Object swap = objects[i];
        objects[i] = objects[j];
        objects[j] = swap;
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        System.arraycopy(a, lo, aux, lo, hi-lo+1);
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if(j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    public static boolean isSorted(Comparable[] comparables) {
        for (int i = 1; i< comparables.length; i++) {
            if (less(comparables[i], comparables[i-1])) {
                return false;
            }
        }
        return true;
    }

    public static void shuffle(Object[] a) {
        for (int i = 1; i < a.length; i++) {
            int r = StdRandom.uniform(i + 1);
            if (r != i) {
                exchange(a, i, r);
            }
        }
    }

}
