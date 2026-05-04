class Solution {
    public boolean isValidSudoku(char[][] board) {
        //row check
        for(int r=0;r<9;r++) {
            Set<Character> s=new HashSet<>();
            for(int i=0;i<9;i++){
                if(board[r][i]=='.')
                continue;
                if(s.contains(board[r][i])) return false;
                s.add(board[r][i]);
            }
        }
        //col check
        for(int c=0;c<9;c++) {
            Set<Character> s=new HashSet<>();
            for(int i=0;i<9;i++){
                if(board[i][c]=='.')
                continue;
                if(s.contains(board[i][c])) return false;
                s.add(board[i][c]);
            }
        }
        //box check
        for(int box=0;box<9;box++){
            Set<Character>s=new HashSet<>();
            //i,j in 0-2 ,0-2
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    //check each box ex 0,0 box inside that all rows,col
                    int row= (box / 3) * 3 + i;
                    int col= (box % 3) * 3 + j;
                    if(board[row][col] == '.') continue;
                    if(s.contains(board[row][col])) return false;
                    s.add(board[row][col]);

                }
            }
        }
        return true;
    }
}
