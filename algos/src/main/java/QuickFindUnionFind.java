package main.java;

public class QuickFindUnionFind {
    private int[] id;

    public QuickFindUnionFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {

        if (id[p] == id[q])
            return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == id[p])
                id[i] = id[q];
        }
    }
}
