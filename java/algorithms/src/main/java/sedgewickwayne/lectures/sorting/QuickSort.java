package sedgewickwayne.lectures.sorting;

import static sedgewickwayne.lectures.sorting.SortingUtils.*;

public class QuickSort {

    final static int CUTOFF =  7;

    public static void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
        assert isSorted(a);
    }

    private static void sort(Comparable[] a, int left, int right) {
        if (right <= left + CUTOFF - 1) {
            InsertionSort.sort(a, left, right);
            return;
        }
        if (right <= left) {
            return;
        }
        int partitionedIndex = partition(a, left, right);
        sort(a, left, partitionedIndex-1);
        sort(a, partitionedIndex+1, right);
    }

    private static int partition(Comparable[] a, int leftBorder, int rightBorder) {
        int leftIndex = leftBorder;
        int rightIndex = rightBorder + 1;
        Comparable v = a[leftIndex];
        while (true) {
            while (less(a[++leftIndex], v)) {
                if (leftIndex == rightBorder) {
                    break;
                }
            }
            while (less(v, a[--rightIndex])) {
                if (rightIndex == leftBorder) {
                    break;
                }
            }
            if (leftIndex >= rightIndex) {
                break;
            }
            exchange(a, leftIndex, rightIndex);
        }
        exchange(a, leftBorder, rightIndex);
        return rightIndex;
    }



}
