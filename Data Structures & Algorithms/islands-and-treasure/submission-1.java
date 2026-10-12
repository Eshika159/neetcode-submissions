class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        //treasure chest(0) to inf[+1] land
        for(int i = 0; i < r; i++){
            for(int j= 0; j < c; j++) {
                if(grid[i][j] == 0){
                    q.add(new int[]{i, j}); //added all treasures as sources
                }
            }
        }
        int[][] dirs = {{0,1}, {0,-1}, {1,0},{-1,0}};

        while(!q.isEmpty()){
            int[] node = q.poll();
            int row = node[0];
            int col = node[1];
            for(int[]dir: dirs) {
                int nr = row + dir[0];
                int nc = col +dir[1];
                if(nr >=0 && nc>=0 && nr < r && nc <c && grid[nr][nc] == Integer.MAX_VALUE) {
                    q.add(new int[]{nr,nc});
                    grid[nr][nc] = grid[row][col] + 1;
                } else {
                    continue;
                }
            }
        }


    }
}
