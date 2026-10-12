class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] par = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];

        for(int i = 0; i < par.length; i++) {
            par[i] = i;
            rank[i] = 1;
        }
        for(int[] edge : edges) {
            if(!union(par,rank,edge[0],edge[1])){
                //already connected
                return new int[] {edge[0], edge[1]};
            }
        }
        return new int[0];
    }
    private int find(int[] par, int node) {
        int p = par[node];
        while(p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }
    return p;
    }
    private boolean union(int[]par, int[]rank, int nu , int nv){
        int u = find(par, nu);
        int v = find(par, nv);
        if( u == v) return false;
        if(rank[u] > rank[v]){
            par[v] = u;
            rank[u] +=rank[v];
        } else {
             par[u] = v;
            rank[v] +=rank[u];
        }
        return true;
    }
}
