class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[]res = new int[numCourses];
        Map<Integer,List<Integer>>adj = new HashMap<>();
        int[] indegree = new int[numCourses];

        for(int i =0 ;i < numCourses; i++) {
            adj.put(i,new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
            indegree[pre[1]]++;
        }
        Queue<Integer>q = new LinkedList<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int finish=0;
        while(!q.isEmpty()){
            int node = q.poll();
            //reverse store since our graph is made rev so sequence reversed
            res[numCourses-finish-1] =node;
            finish++;
            for(int ed: adj.get(node)){
                indegree[ed]--;
                if(indegree[ed] == 0)
                    q.add(ed);
            }
        }
        if(finish != numCourses){
            return new int[0];
        }

        return res;


    }
}
