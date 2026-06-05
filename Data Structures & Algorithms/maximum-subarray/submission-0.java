class Solution {
    public int maxSubArray(int[] nums) {
        int maxsum = nums[0];
        int cursum = 0;

        for(int i : nums) {
            //maintaining pos sum
            if(cursum < 0){
                cursum = 0;
            }
            cursum += i;
            maxsum = Math.max(maxsum,cursum);

        }
        return maxsum;
        
    }
}
