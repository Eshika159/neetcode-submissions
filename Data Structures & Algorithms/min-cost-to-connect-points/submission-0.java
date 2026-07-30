class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        //build adj
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i+1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                adj.computeIfAbsent(i, k -> new ArrayList<>()).add(new int[] {dist, j});
                adj.computeIfAbsent(j, k -> new ArrayList<>()).add(new int[] {dist, i});
            }
        }
        int res = 0;
        Set<Integer> visit = new HashSet<>();
        PriorityQueue<int[]> minheap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); //distance min
        minheap.add(new int[]{0,0});
        while(visit.size() < n) {
            int[] cur = minheap.poll();
            int cost = cur[0];
            int i = cur[1];
            if(visit.contains(i)) continue;
            res+= cost;
            visit.add(i);
            for(int[] nei : adj.getOrDefault(i, Collections.emptyList())) {
                int ncost = nei[0];
                int neiIdx = nei[1];
                if(!visit.contains(neiIdx)){
                    minheap.add(new int[]{ncost, neiIdx});
                }
            }
        }
        return res;

    }
}
