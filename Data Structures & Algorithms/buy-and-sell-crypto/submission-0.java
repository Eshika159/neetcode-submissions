class Solution {
    public int maxProfit(int[] prices) {
        int l=0;
        int r=l+1;
        int profit=0;
        while(r < prices.length){
            if(prices[l] < prices[r]) {
                profit = Math.max(profit,prices[r]-prices[l]);
            }
            else{
                l=r; //move l pointer to lowest value i.e r
            }
            r++;
        }
        return profit;
    }
}
