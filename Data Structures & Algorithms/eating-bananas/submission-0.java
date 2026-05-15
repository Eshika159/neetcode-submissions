class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // l -r [1....max piles]
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;

        while (l <= r) {
            int k = (l + r) / 2;
            long hr = 0;
            for( int p : piles) {
                hr += Math.ceil((double) p / k); 
            }
            if(hr <= h) {
                res = Math.min(res, k);
                r = k - 1;
            }
            else {
                //given k is not sufficient, need to inc k (more banana)
                l = k + 1;
            }
        }
        return res;
    }
}
