class Solution {
    public int maxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int prefix = 1, suffix = 1;
        //nums = [2,3,-2,-4]
        int n = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix = prefix * nums[i];
            suffix = suffix * nums[n - i -1];
            res= Math.max(res, Math.max(prefix,suffix));
        }
        return res;
    }
}
