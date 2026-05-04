class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        int ans[]=new int[k];
        
        for(int i : nums) {
            map.put(i , map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            int[] arr=new int[2];
            arr[0]=entry.getKey(); arr[1]=entry.getValue(); // (ele,freq)
            pq.add(arr);
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
