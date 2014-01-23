package sedgewickwayne.lectures.unionfind;

public class WeightedQuickUnionUnionFind implements UnionFind {

    private int[] id;
    private int[] sz;

    public WeightedQuickUnionUnionFind(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root (int i) {
        while (i != id[i]) {
            i = id[i];
        }
        return i;
    }

}
