class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int time  = 0; int fresh = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j <grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j}); //added rotten
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0, -1}};
        while(fresh > 0 && !q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];

                for(int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if( nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length
                    && grid[nr][nc] == 1) {
                        //fresh to rotten
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                        fresh--;
                    }
                }
            }
            time++;

        }
        return fresh == 0 ? time : -1;

    }
}
