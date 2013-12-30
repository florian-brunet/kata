package sedgewickwayne.p1unionfind;

public class QuickUnionUnionFind implements UnionFind {

    private int[] id;

    public QuickUnionUnionFind(int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        id[i] = j;
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
