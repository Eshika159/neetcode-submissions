class Solution {
    int[] dp;
    public int climbStairs(int n) {
        //memoization
        dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = -1;
        }
        return dfs(n, 0);
    }

    public int dfs(int n, int i) {
        if(i >= n) return i == n ? 1 : 0;
        if ( dp[i] != -1) return dp[i];
        return dp[i] = dfs(n, i + 1) + dfs(n, i + 2);
    }
}
