class Solution {
    public int findMin(int[] nums) {
        //find deflection point
        int mid = 0, l =0 , r=nums.length-1;
        while(l<r){
             mid = l + (r-l)/2;
            if(nums[mid] > nums[r]) {
                l = mid +1;
            }
            // mid is less than right- it lies on left
            else {
                r = mid;
            }
        }
        return nums[l];
      
    }
}
