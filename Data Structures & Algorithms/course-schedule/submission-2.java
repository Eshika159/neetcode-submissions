class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        //make empty graph
        for(int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }
        //indegree , graph
        for(int[] pre: prerequisites) {
            // [0,1] -> 0 -> 1
            adj.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;            
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }
        int fin = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            fin++;
            for(int ed : adj.get(node)) {
                indegree[ed]--;
                if(indegree[ed] == 0) {
                    q.add(ed);
                }
            }
        }
        return fin == numCourses;
    }
}
