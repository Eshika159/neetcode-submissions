class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }     
        }
        int[][] dirs = { { 0, 1 }, { 0, -1 },{ 1, 0 },{ -1, 0 } };
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int row = node[0]; //current cell starting from treasure to land(INF)
            int col = node[1];
            for(int[] dir: dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >=0 && nr < r && nc >= 0 && nc < c && grid[nr][nc] == Integer.MAX_VALUE ) {
                    q.add(new int[] {nr ,nc});
                    grid[nr][nc] = grid[row][col] + 1; //distance + 1 (from treasure + 1 then keeps on +1)
                } else {
                    continue;
                }
            }
        }
    }
}
