class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        rank[i] = 1;
      }  
    }

    public int find(int node) {
        int i = node;
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        //if same parent no union
        if(pu == pv) {
            return false;
        }
        //this is size
        if(rank[pv] > rank[pu]) {
            parent[pu] = pv;
            rank[pv] += rank[pu];
        } else {
            parent[pv] = pu;
            rank[pu] += rank[pv];
        }
        return true;
    }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int res = n;
        for (int[] edge : edges) {
            if (dsu.union(edge[0], edge[1])) {
                res--;
            }
        }
        return res;
    }
}
