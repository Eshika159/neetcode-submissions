class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        //memo solutn
        memo = new int[text1.length() + 1][text2.length() + 1];
        for(int i = 0; i <= text1.length(); i++){
            for(int j =0 ; j <= text2.length(); j++ ){
                memo[i][j] = -1;
            }
        }
       return dfs(text1, text2, text1.length(), text2.length());
    }

    private int dfs(String text1, String text2, int n , int m) {
        if(n ==0 || m == 0){
            return 0;
        }
        if(memo[n][m] != -1) return memo[n][m];

        //if last char matches now check for n-1 & m-1
        if(text1.charAt(n - 1) == text2.charAt(m - 1)){
            memo[n][m]= 1 + dfs(text1, text2, n - 1, m -1);
        } 
        else{ 
            memo[n][m] = Math.max(dfs(text1, text2, n-1,m), dfs(text1, text2, n, m - 1)); 
        }
        return memo[n][m];
    }
}
