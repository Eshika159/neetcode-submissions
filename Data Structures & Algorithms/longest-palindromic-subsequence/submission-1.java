class Solution {
    int[][] memo;
    public int longestPalindromeSubseq(String s) {
          //memo solutn using LPS = LCS(s1, reverseof s1)
          String s2 = new StringBuilder(s).reverse().toString();
        memo = new int[s.length() + 1][s2.length() + 1];
        for(int i = 0; i <= s.length(); i++){
            for(int j =0 ; j <= s2.length(); j++ ){
                memo[i][j] = -1;
            }
        }
       return dfs(s, s2, s.length(), s2.length());
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