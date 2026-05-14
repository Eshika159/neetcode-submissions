class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int top = 0, bot = r -1;
        while (top <= bot) {
            int row = (top + bot) / 2;
            if(target > matrix[row][c-1]) {
                top = row + 1;
            }
            else if (target < matrix[row][0]) {
                bot = row - 1;
            }
            else {
                break;
            }
        }
        if ( !(top <= bot)) {
            return false;
        }
        int row = (top + bot) / 2;
        int l =0 , ri = c - 1;
        while (l <= ri){
            int m = (l+ri)/2;
            if (target > matrix[row][m]) {
                l = m + 1;
            }
            else if (target < matrix[row][m]) {
                ri = m - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }
}
