class Solution {
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length , cols = heights[0].length;
        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];
        Queue<int[]> pacq = new LinkedList<>();
        Queue<int[]> atlq = new LinkedList<>();

        for(int c = 0; c < cols; c++) {
            pac[0][c] = true;
            atl[rows-1][c] = true;
            pacq.add(new int[]{0, c});
            atlq.add(new int[]{rows - 1, c});
        }
        for(int r = 0; r < rows; r++) {
            pac[r][0] = true;
            atl[r][cols - 1] = true;
            pacq.add(new int[]{r, 0});
            atlq.add(new int[]{r, cols - 1});
        }
        List<List<Integer>> res = new ArrayList<>();

        bfs(pacq, pac , heights);
        bfs(atlq, atl, heights);

        for(int r = 0 ; r < rows; r++){
            for(int c = 0; c < cols; c++) {
                if(pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights) {
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
            for(int dir[] : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >=0 && nr <heights.length && nc >= 0 && nc < heights[0].length 
                && !ocean[nr][nc] && heights[nr][nc]>= heights[r][c]) {
                    ocean[nr][nc] = true; //mark visited not on pop as same 2 cell can have same neigh why add twice in queue
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}
