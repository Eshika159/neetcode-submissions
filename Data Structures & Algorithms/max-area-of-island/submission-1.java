class Solution {
    private static final int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int maxarea = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols;c++){
                if(grid[r][c] == 1){
                    maxarea= Math.max(maxarea,bfs(grid, r, c));
                }
            }
        }
        return maxarea;
    }

    public int bfs(int[][] grid, int r ,int c) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        grid[r][c] = 0; //visited
        int area = 1;

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0] , col = node[1];
            for(int dir[] : directions) {
                int nr = row + dir[0] , nc = col + dir[1];
                if(nr >= 0 && nc >=0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = 0;
                    area++;
                }
            }
        }
        return area;
    }
}
