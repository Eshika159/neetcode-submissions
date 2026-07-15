class Solution {
    public int maxProfit(int[] prices) {
       // [10,1,5,6,7,1]
       int l = 0;
       int r = l + 1;
       int profit = 0;
       while (r < prices.length) {
        if( prices[l] < prices[r]) {
            profit = Math.max(profit, prices[r] - prices[l]);
        } else {
            l = r;
        }
        r++;
       }
        return profit;
    }
}
