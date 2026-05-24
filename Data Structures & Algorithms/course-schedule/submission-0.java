class Solution {

    private Map<Integer,List<Integer>> premap=new HashMap<>();

    private Set<Integer> visit = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i =0;i<numCourses;i++){
            premap.put(i,new ArrayList<>());
        }
        for(int []pre: prerequisites) {
            premap.get(pre[0]).add(pre[1]);
        }
        for(int c=0;c<numCourses;c++){
            // if not true
           if( !dfs(c)){
            return false;
           }
        }
        return true;
    }

    public boolean dfs(int c){
        if(visit.contains(c)){
            return false;
        }
        if(premap.get(c).isEmpty()){
            return true;
        }
        visit.add(c);
        for(int p : premap.get(c)){
            if(!dfs(p)){
                return false;
            }
        }
        visit.remove(c);
        premap.put(c,new ArrayList<>());
        return true;
    }
}
