class Solution {
    public int longestConsecutive(int[] nums) {
        int res=0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i< nums.length ; i++) {
            set.add(nums[i]);
        }
        for( int i=0 ;i<nums.length;i++){
            //starting from smallest nums[i] to go till max i.e 2 till 5
            if(!set.contains(nums[i]-1)) {
                int count=1;
                while(set.contains(nums[i]+count) ){
                    count++;
                }
            res=Math.max(res,count);
            }
        }
        return res;
    }
}
