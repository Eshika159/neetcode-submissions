class Solution {
    public int minCostClimbingStairs(int[] cost) {
        //[10,15,20] 0 ] so last 2 indexes are base case it doesnt need calculation
        //also we can start from index = 0 or 1
        for(int i = cost.length - 3; i>=0; i--) {
            cost[i] += Math.min(cost[i+1], cost[i + 2]);
        }
        return Math.min(cost[0], cost[1]);
    }
}
