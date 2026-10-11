class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int l = 0, r = 0;

        while(r < n) {
            //elements in q are smaller than incoming -> pop
            while(!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);
            //remove out of bound element from last window
            if( l > q.getFirst()) {
                q.removeFirst();
            }
            //maintain k size window
            if ( (r + 1) >= k) {
                output[l] = nums[q.getFirst()];
                l++;
            }
            r++;
        }
        return output;
    }
}
