class Solution {
    private static final int[][] directions ={{0,1},{1,0},{0,-1},{-1,0}};

    public int numIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int islands = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == '1') {
                    bfs(grid, i, j);
                    islands++;
                }
            }
        }
        return islands;
        
    }
    
    public void bfs(char[][] grid, int r , int c) {
        Queue<int[]> q = new LinkedList<>();
        grid[r][c] = '0';
        q.add(new int[]{r, c});

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];
            for(int[] dir : directions) {
                int nr = row + dir[0], nc = col + dir[1];
                if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0'; //marked visited
                }
            }
        }
    }
}
