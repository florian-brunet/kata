package sedgewickwayne.experiments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static sedgewickwayne.p3sorting.SortingUtils.shuffle;

public class SortingExperiment {

    private static final Logger LOGGER = LoggerFactory.getLogger(SortingExperiment.class);

    public static void main(String[] args) {
        SortingExperiment sortingExperiment = new SortingExperiment();
        sortingExperiment.execute();
    }

    private interface Sort {
        void sort(Comparable[] a);
    }

    public void execute() {
        int N = 32;
        while (N <= (1 << 16)) {
            LOGGER.info("Running experiment for N = " + N);
            for (int statistic = 0; statistic < 1000; statistic++) {
                Integer[] a = new Integer[N];
                for (int i = 0; i < N; i++) {
                    a[i] = i;
                }
                shuffle(a);
            }
            N *= 2;
        }
    }

}
