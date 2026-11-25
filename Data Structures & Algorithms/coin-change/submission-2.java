class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1];
        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for(int j = 0; j < amount + 1; j++){
            dp[0][j] = Integer.MAX_VALUE - 1;
        }
        //for n =1 first coin ,n= 1 row how many coins can make j
        for(int j = 1; j < amount +1; j++){
            if(j % coins[0] == 0) {
                dp[1][j] = j / coins[0];
            } else {
                dp[1][j] = Integer.MAX_VALUE - 1; //not possible
            }
        }
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < amount +1; j++) {
                if(coins[i - 1] <= j) {
                    // unbounded knapsack mul times we can pick same so dp[i][j - coins[i]]
                    // coins[i - 1] because indexing in coin arr. first coin is i-1 and n = 1 i.e i value
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]] , dp[i - 1][j]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1: dp[n][amount] ;
    }
}
