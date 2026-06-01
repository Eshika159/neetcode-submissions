class DSU{
    private int[] parent;
    private int[] size;
    public DSU(int n){
        //n +1 because of 1 based index
        parent = new int[n + 1];
        size = new int[n +1];
        for(int i =1;i<=n;i++){
            parent[i] = i;
            size[i] =1;
        }
    }
    public int find(int node) {
        if(node != parent[node]){
            parent[node] = find(parent[node]); 
        }
        return parent[node];
        
    }
    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if(pu == pv) return false;
        if(size[pu] >= size[pv]) {
            parent[pv] = pu;
            size[pu]+=size[pv];
        } else {
            parent[pu] = pv;
            size[pv] +=size[pu];

        }
        return true;

    }


}

class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        DSU dsu = new DSU(rows * cols);

        int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
        int islands = 0;

        for(int r =0; r<rows;r++){
            for(int c = 0;c<cols;c++){
                if(grid[r][c] == '1'){
                    islands++;
                    for(int[] d : directions){
                        int nr = r + d[0];
                        int nc = c + d[1];
                        if(nr >=0 && nc >=0 && nr<rows && nc<cols &&
                        grid[nr][nc] == '1'){
                            if(dsu.union(r * cols + c , nr * cols + nc)){
                                islands--;
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}
