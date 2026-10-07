class Solution {
    public int[] topKFrequent(int[] nums, int k) {
     Map<Integer,Integer> count = new HashMap<>();
     for(int num : nums) {
        count.put(num, count.getOrDefault(num,0) + 1);
     }   
     //min heap on freq (min freq el will be popped out)
     PriorityQueue<int[]>heap = new PriorityQueue<>((a,b) -> a[1]- b[1]);
    for(Map.Entry<Integer,Integer> entry: count.entrySet()) {
        heap.add(new int[] {entry.getKey(), entry.getValue()});
        if(heap.size() > k){
            heap.poll(); //poll small freq element out
        }
    }
    int[] res = new int[k];
    for(int i = 0; i < k; i++) {
        res[i] = heap.poll()[0];
    }
    return res;
    }
}
