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
        int cur = node;
        while (cur != parent[cur]) {
            parent[cur] = parent[parent[cur]]; //path compression
            cur = parent[cur];
        }
        return cur;
     }
     public boolean union (int u, int v){
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return false;
        if(rank[pv] > rank[pu]) {
            parent[pu] = pv;
            rank[pv]+= rank[pu];
        } else {
            parent[pv] = pu;
            rank[pu]+= rank[pv];
        }
        return true;
     }
}
class Solution {
    public int countComponents(int n, int[][] edges) {
        int res = n;
        DSU dsu = new DSU(n);
        for(int[] edg: edges){
            if(dsu.union(edg[0],edg[1])){
                res--;
            }
        }
        return res;
    }
}
