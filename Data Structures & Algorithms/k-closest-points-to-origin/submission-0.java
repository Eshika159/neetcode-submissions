class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //distance , x , y and a min heap of size k
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for(int[] point : points) {
            int distance = point[0] * point[0] + point[1] * point[1];
            pq.add(new int[] {distance, point[0], point[1]});
        }
        int[][] res = new int[k][2];
        for(int i =0; i < k; i++){
            int[] point = pq.poll();
            res[i] = new int[] {point[1], point[2]};
        }
        return res;
    }
}
