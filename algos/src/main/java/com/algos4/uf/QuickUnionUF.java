package main.java.com.algos4.uf;

/**
 * Tress can get tall
 *
 * Find has become too expensive.
 */
public class QuickUnionUF {

    int id[];

    /**
     * Set each obejct to itself.
     *
     * @param N
     */
    public QuickUnionUF(int N) {
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * Check P and q has same root
     * depth of p and q array accesses.
     * @param p
     * @param q
     * @return
     */
    private boolean isConnected(int p, int q) {
        return rootOf(p) == rootOf(q);
    }

    /**
     * Chase parent pointers until reach root. Depth of i array accesses.
     * @param i
     * @return
     */
    private int rootOf(int i) {
        while (i != id[i])
            i = id[i];

        return i;
    }

    /**
     * Change root of P to point to root of q.
     * Depth of p and q array accesses.
     * @param p
     * @param q
     */
    private void union(int p, int q) {
        int i = rootOf(p);
        int j = rootOf(q);
        id[i] = j;
    }
}
