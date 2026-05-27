class Solution {
    private Map<Integer,List<Integer>> adj;
    private Map<Integer,Set<Integer>> prereq;

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        adj = new HashMap<>();
        prereq = new HashMap<>();
        for(int i =0 ;i <numCourses; i++) {
            adj.put(i,new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            // [1,0] take 1 before 0 , so for 0-> 1
            adj.get(pre[1]).add(pre[0]);
        }
        for( int c = 0; c < numCourses; c++){
            dfs(c);
        }
        List<Boolean> res = new ArrayList<>();
        for(int [] query : queries) {
            res.add(prereq.get(query[1]).contains(query[0]));
        }
        return res;



    }

    private Set<Integer> dfs(int c){
        if(prereq.containsKey(c))
        return prereq.get(c);
        Set<Integer> set = new HashSet<>();
        //adj of a node
        for(int pre : adj.get(c)) {
            set.addAll(dfs(pre));
        }
        set.add(c);
        prereq.put(c, set);
        return set;






    }
}