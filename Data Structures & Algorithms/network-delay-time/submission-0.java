class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> edges = new HashMap<>();

        for(int[] time : times) {
            edges.computeIfAbsent(time[0],
             a -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minheap.add(new int[]{0, k});

        Set<Integer> set = new HashSet<>();
        int len = 0;

        while(!minheap.isEmpty()) {
            int[] cur = minheap.poll();
            int w1 = cur[0], n1 = cur[1];
            if(set.contains(n1)) continue;

            set.add(n1);
            len = w1;
            if(edges.containsKey(n1)) {
                for(int[] nei : edges.get(n1)) {
                    int n2 = nei[0], w2 = nei[1];
                    if(!set.contains(n2)) {
                        minheap.add(new int[]{w1+w2, n2});
                    }
                }
            }
        } 
        return set.size() == n ? len : -1;
    }
}
