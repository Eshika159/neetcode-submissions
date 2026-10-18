class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum+= nums[i];
        }
        if(sum%2 != 0 ) return false;

        return isSubsetSum(nums, sum/2);
    }
        static boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        boolean dp[][] = new boolean[n + 1][sum + 1];
        for(int i = 0; i<=n; i++){
            dp[i][0] = true;
        }
       for(int j = 1; j<=sum; j++){
            dp[0][j] = false;
        }
        for(int i = 1; i <=n ; i++){
            for(int j = 1; j <= sum; j++) {
            if(arr[i - 1] <= j) {
                dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j]; //pick,not pick
                
            }  else{
                dp[i][j] = dp[i - 1][j];
            } 
            }
        }
        return dp[n][sum];
    }
}
