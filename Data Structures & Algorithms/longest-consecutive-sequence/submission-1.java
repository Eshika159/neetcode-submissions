class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i] - 1)) {  //this is smallest elem
                int c = 1;
                while(set.contains(nums[i] + c)) {
                    c++;
                }
                res= Math.max(res,c);
            }
        }
        return res;
    }
}
