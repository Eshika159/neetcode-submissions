class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
         if(n == 1) return nums[n - 1];

         int[] dp1 = new int[n];
         int[] dp2 = new int[n];

         Arrays.fill(dp1, -1);
         Arrays.fill(dp2, -1);
         //include 0th and exclude last
         int case1 = maximum(0, n-2, nums, dp1);
         //exclude first
         int case2 = maximum(1, n-1, nums,dp2);

         return Math.max(case1, case2);
    
    }
    private int maximum(int i , int end , int[] nums, int[]dp) {
        //base cases
        if(i > end) return 0;
        if(dp[i] != -1) return dp[i];

        int robCurrent = nums[i] + maximum(i + 2, end, nums, dp);
        int skip = maximum(i + 1, end, nums, dp);

        return dp[i] = Math.max(robCurrent,skip);


    }
}
