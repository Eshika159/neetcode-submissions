class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        int l = 0 , r=0 ;
        Deque<Integer> q = new LinkedList<>();
        while ( r < n) {
            //pop small elements then add bigger element
            while(!q.isEmpty() && nums[r] > nums[q.getLast()]) {
                q.removeLast();
            }
            q.addLast(r);

            //remove element no longer in window    
            if (l > q.getFirst()){
                q.removeFirst();
            }
            //window 
            if( (r + 1) >= k) {
                output[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return output;
    }
}
