package main.java.com.algos4.uf;

public class QuickFindUF {
    private int[] id;

    /**
     * Number of times array access - N
     * @param n
     */
    public QuickFindUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * Number of times array access - 2
     * @param p
     * @param q
     * @return
     */
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    /**
     * Takes quadratic time. Quadratic algorithms do not scale with technology.
     * Number of times array access - N^2
     * @param p
     * @param q
     */
    public void union(int p, int q) {

        if (id[p] == id[q])
            return;

        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid)
                id[i] = qid;
        }
    }
}
