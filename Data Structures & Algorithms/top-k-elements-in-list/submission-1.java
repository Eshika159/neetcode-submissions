class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        int ans[]=new int[k];
        
        for(int i : nums) {
            map.put(i , map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
            if(pq.size() > k){ 
                pq.poll();
            }
        }
        int i=0;
        while(!pq.isEmpty()){
                ans[i++] = pq.poll()[0];
        }

        return ans;

    }
}
