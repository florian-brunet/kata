package sedgewickwayne.experiments;

import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sedgewickwayne.sorting.*;

import java.io.FileWriter;
import java.util.Map;

import static sedgewickwayne.sorting.SortingUtils.shuffle;

public class SortingExperiment {

    private static final int MINIMUM_ARRAY_SIZE = 32;
    private static final int MAXIMUM_ARRAY_SIZE = 1 << 10;
    private static final int STATISTIC_SIZE = 300;

    private static final Logger LOGGER = LoggerFactory.getLogger(SortingExperiment.class);

    public static void main(String[] args) throws Exception {
        SortingExperiment sortingExperiment = new SortingExperiment();
        sortingExperiment.execute();
    }

    public void execute() throws Exception {
        Map<String, SortingAlgorithm> sortingAlgorithms = initializeSortingAlgorithms();
        Map<String, FileWriter> dataWriters = Maps.newHashMap();
        for (String algorithmName : sortingAlgorithms.keySet()) {
            dataWriters.put(algorithmName, new FileWriter(algorithmName+".dat"));
        }
        int N = MINIMUM_ARRAY_SIZE;
        while (N <= MAXIMUM_ARRAY_SIZE) {
            Map<String, Long> cumulativeExecutionTimes = Maps.newHashMap();
            for (String algorithmName : sortingAlgorithms.keySet()) {
                cumulativeExecutionTimes.put(algorithmName, 0L);
            }
            LOGGER.info("Running experiment for N = " + N);
            for (int statistic = 0; statistic < STATISTIC_SIZE; statistic++) {
                Integer[] a = new Integer[N];
                for (int i = 0; i < N; i++) {
                    a[i] = i;
                }
                shuffle(a);
                for (String algorithmName : sortingAlgorithms.keySet()) {
                    long executionTime = measureSingleSortingAlgorithm(sortingAlgorithms.get(algorithmName),a.clone());
                    cumulativeExecutionTimes.put(algorithmName,
                            cumulativeExecutionTimes.get(algorithmName) + executionTime);
                }
            }
            for (String algorithmName : sortingAlgorithms.keySet()) {
                dataWriters.get(algorithmName).write(String.format("%d %d\n", N,
                        cumulativeExecutionTimes.get(algorithmName)/STATISTIC_SIZE));
            }
            N *= 2;
        }
        for (String algorithmName : dataWriters.keySet()) {
            dataWriters.get(algorithmName).close();
        }
    }

    public long measureSingleSortingAlgorithm(SortingAlgorithm sortingAlgorithm, Integer[] a) {
        long startTime = System.nanoTime();
        sortingAlgorithm.sort(a);
        long endTime = System.nanoTime();
        return endTime-startTime;
    }

    private interface SortingAlgorithm {
        void sort(Comparable[] a);
    }

    public Map<String, SortingAlgorithm> initializeSortingAlgorithms() {
        Map<String, SortingAlgorithm> sortingAlgorithms = Maps.newHashMap();
        sortingAlgorithms.put("SelectionSort", new SortingAlgorithm() {
            @Override
            public void sort(Comparable[] a) {
                SelectionSort.sort(a);
            }
        });
        sortingAlgorithms.put("InsertionSort", new SortingAlgorithm() {
            @Override
            public void sort(Comparable[] a) {
                InsertionSort.sort(a);
            }
        });
        sortingAlgorithms.put("ShellSort", new SortingAlgorithm() {
            @Override
            public void sort(Comparable[] a) {
                ShellSort.sort(a);
            }
        });
        sortingAlgorithms.put("MergeSort", new SortingAlgorithm() {
            @Override
            public void sort(Comparable[] a) {
                MergeSort.sort(a);
            }
        });
        sortingAlgorithms.put("BottomUpMergeSort", new SortingAlgorithm() {
            @Override
            public void sort(Comparable[] a) {
                BottomUpMergeSort.sort(a);
            }
        });
        sortingAlgorithms.put("QuickSort", new SortingAlgorithm() {
            @Override
            public void sort(Comparable[] a) {
                QuickSort.sort(a);
            }
        });
        return sortingAlgorithms;
    }

}
