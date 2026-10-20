class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return f(n-1, nums,dp); //starting last index f(3)
    }
    public int f(int i , int[] nums,int[] dp) {
        if(i == 0) return nums[i];
        if(i < 0) return 0; //f(3) means max between 0...3 
        if(dp[i] != -1) return dp[i]; //storing calculated result - memoization
        //[1,2,5,6]
        int pick = nums[i] + f(i-2, nums,dp);// nums[3]+f(1)
        int notpick = 0 + f(i - 1,nums,dp); //f(2)
        return dp[i]=Math.max(pick,notpick);
    }
}
//tc - o(n) sc - o(n)
