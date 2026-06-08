class Solution {
    public boolean canJump(int[] nums) {
        //max index reachable
        int maxindex = 0;
        //curr i 
        for(int i = 0; i < nums.length; i++) {
            if(i > maxindex) {
                return false;
            }
            maxindex = Math.max(maxindex,i + nums[i]);
        }
        return true;
    }
}
