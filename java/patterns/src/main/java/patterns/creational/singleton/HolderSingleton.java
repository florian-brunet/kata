package patterns.creational.singleton;

public class HolderSingleton {

    private HolderSingleton() {}

    private static class Holder {
        public static final HolderSingleton INSTANCE = new HolderSingleton();
    }

    public static HolderSingleton getInstacnce() {
        return Holder.INSTANCE;
    }

}
