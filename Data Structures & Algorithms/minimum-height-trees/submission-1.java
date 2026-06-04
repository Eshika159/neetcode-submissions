class Solution {
    //topological sort- bfs indegree 1 insert
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Collections.singletonList(0);

        //array of list
        List<Integer>[] adj = new ArrayList[n];
        for(int i = 0;i< n;i++){
            adj[i] = new ArrayList<>();
        }
        for(int[] edge : edges){
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < n ;i++) {
            indegree[i] = adj[i].size();
            if(adj[i].size() == 1){
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int s = q.size();
            ans.clear();
            for(int i = 0;i<s;i++){
              int  node = q.poll();
              ans.add(node);
              for(int nei : adj[node]){
                indegree[nei]--;
                if(indegree[nei] == 1){
                    q.add(nei);
                }
              } 
            }

        }
        return ans;
    }
}