class Solution {
    public String foreignDictionary(String[] words) {
      //using topological sort

      Map<Character,Set<Character>> adj = new HashMap<>();
      Map<Character,Integer> indegree = new HashMap<>();

      for(String word : words) {
        for(char c: word.toCharArray()) {
            adj.put(c,new HashSet<>());
            indegree.putIfAbsent(c,0);
        }
      }
      for(int i=0; i < words.length-1; i++){
        String w1 = words[i];
        String w2 = words[i+1];
        int minLen=Math.min(w1.length(),w2.length());
        //invalid string abcd , abc 
        if(w1.length() > w2.length() && w1.substring(0,minLen).equals(w2.substring(0,minLen))) {
            return "";
        }
        for(int j = 0; j< minLen; j++) {
            //find indiff char
            if(w1.charAt(j) != w2.charAt(j)){
                //build grph
                if(!adj.get(w1.charAt(j)).contains(w2.charAt(j))){
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    indegree.put(w2.charAt(j), indegree.get(w2.charAt(j))+1);
                }
                break;
            }
        }

        }
        StringBuilder res = new StringBuilder();
        //graph is built now do topo sort using q
        Queue<Character> q =new LinkedList<>();
        for ( char c : indegree.keySet()){
            if(indegree.get(c)== 0){
                q.add(c);
            }
        }
        while(!q.isEmpty()) {
            char vertex = q.poll();
            res.append(vertex);
            for(char neigh : adj.get(vertex)) {
                indegree.put(neigh,indegree.get(neigh) -1);
                if(indegree.get(neigh) == 0){
                    q.add(neigh);
                }
            }
        }
        //cycle exist
        if(res.length() != indegree.size()){
            return "";
        }
        return res.toString();
      
    }
}
