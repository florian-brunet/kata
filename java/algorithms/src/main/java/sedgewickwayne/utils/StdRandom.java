package sedgewickwayne.utils;

import java.util.Random;

public class StdRandom {

    private static Random random;
    private static long seed;

    static {
        seed = System.currentTimeMillis();
        random = new Random(seed);
    }

    public static int uniform(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException("N must be positive");
        }
        return random.nextInt(N);
    }

}
