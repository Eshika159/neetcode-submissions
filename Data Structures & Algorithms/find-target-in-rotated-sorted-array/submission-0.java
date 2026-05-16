class Solution {
    public int search(int[] nums, int target) {
        int mid = 0 , l =0, r = nums.length -1;

        while (l < r) {
            mid = l+ (r-l)/2;
            //find pivot - smallest el
            if( nums[mid] > nums[r] ) {
                l= mid+1;
            }
            else{
                r= mid;
            }
        }
        //pivot is l
        int pivot = l;
        l =0;
        r = nums.length -1;
        //now find whether target lies in left or right side of pivot
        if( target >= nums[pivot] && target <= nums[r]) {
            l = pivot;
        }
        else {
            r = pivot - 1;
        }
        while(l<=r) {
            int m = (l+r)/2;
            if(nums[m] == target){
                return m;
            }
            else if (nums[m] < target){
                l = m+1;
            }
            else {
                r = m-1;
            }
        }


        return -1;
    }
}
