class Solution {
    private int rows, cols;
    private int[][] dirs = new int[][] { {1,0},{0,1},{-1,0}, {0,-1}};
    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;

        surround(board);

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O'; // cant be flipped since connected to o edges
                }
            }
        }
    }

    public void surround(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if((r == 0 || r == rows - 1 || c == 0 || c == cols - 1) && board[r][c] == 'O') {
                    //O on the edge add to the queue
                    board[r][c] = 'T';
                    q.add(new int[]{r, c});
                }
            }
        }
        //check of connected regions of 'O' that wont be converted
        while(!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0];
            int c = node[1];
                for(int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    if(nr >=0 && nr < rows && nc >= 0 && nc < cols && board[nr][nc] == 'O' ) {
                        board[nr][nc] = 'T';
                        q.add(new int[]{nr , nc});
                    }
                }
            
        }

    }
}
