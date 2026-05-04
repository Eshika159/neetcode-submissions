class Solution {
    public int trap(int[] height) {
        //without extra space using 2 pointer
        int n=height.length;
        if (height == null || n == 0) {
            return 0;
        }
        int l=0,r=n-1;
        int leftmax = height[l], rightmax = height[r];
        int res = 0;
        while (l < r) {
            //both corners cant store water
            if(leftmax < rightmax) {
            l++;
            leftmax=Math.max(leftmax,height[l]);
            res += leftmax - height[l];
            }
            else {
                r--;
                rightmax= Math.max(rightmax,height[r]);
                res+= rightmax- height[r];
            }
        }
        return res;
    }
}
