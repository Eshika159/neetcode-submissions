class Solution {
    private static final int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int maxArea = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                 maxArea= Math.max(maxArea, bfs(grid, i ,j));
                }
            }
        }
        return maxArea;
    }

    public int bfs(int[][] grid, int r ,int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        grid[r][c] = 0;
        int curr = 1;

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0], col = node[1];

            for(int dir[] : directions) {
                int nr = row + dir[0] , nc = col + dir[1];
                if(nr >= 0 && nr < grid.length && nc >=0 && nc < grid[0].length 
                && grid[nr][nc] == 1) {
                    q.add(new int[]{nr, nc}); // neigh added 
                    grid[nr][nc] = 0;
                    curr++;
                }
            }
        }
        return curr;
    }
}
