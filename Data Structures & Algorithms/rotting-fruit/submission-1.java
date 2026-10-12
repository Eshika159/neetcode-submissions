class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int time=0, fresh = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j =0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new int[]{i,j}); // add rotten
                } else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while(fresh > 0 && !q.isEmpty()) {
            int length = q.size();
            for(int i = 0; i < length; i++) {
                int[] node = q.poll();
                int r = node[0];
                int c = node[1];
                for(int[] dirs : directions) {
                    int nr = r + dirs[0];
                    int nc = c + dirs[1];
                    if(nr>=0 && nr < grid.length && nc >=0 && nc < grid[0].length && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        q.add(new int[]{nr, nc});
                        fresh --;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}
