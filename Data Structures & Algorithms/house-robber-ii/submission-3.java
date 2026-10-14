class Solution {
    public int rob(int[] nums) {
         int n = nums.length;

        if (n == 1) return nums[0];

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

         // Case 1: Exclude last house (index n-1)
        int case1 = f(n - 2, 0, nums, dp1);

        // Case 2: Exclude first house (index 0)
        int case2 = f(n - 1, 1, nums, dp2);

        return Math.max(case1, case2);
    }
     public int f(int i, int start, int[] nums, int[] dp) {
        if (i < start) return 0;

        if (i == start) return nums[i];

        if (dp[i] != -1) return dp[i];

        int pick = nums[i] + f(i - 2, start, nums, dp);
        int notpick = f(i - 1, start, nums, dp);

        return dp[i] = Math.max(pick, notpick);
    }
}
