package sedgewickwayne.p3sorting;

import java.util.Random;

public class SortingUtils {

    public static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    public static void exchange(Object[] objects, int i, int j) {
        Object swap = objects[i];
        objects[i] = objects[j];
        objects[j] = swap;
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
        Random random = new Random();
        for (int i = 1; i < a.length; i++) {
            int r = random.nextInt(i+1);
            if (r != i) {
                exchange(a, i, r);
            }
        }
    }

}
