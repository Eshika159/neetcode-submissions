class Solution {
    public String foreignDictionary(String[] words) {
      //topological sort
      Map<Character, Set<Character>> adj = new HashMap<>();
      Map<Character, Integer> indegree= new HashMap<>();
        //build adj
      for(String word: words) {
        for(char c : word.toCharArray()) {
            adj.put(c, new HashSet<>());
            indegree.putIfAbsent(c,0);
        }
      }
    //compare words to build 
    for(int i = 0; i < words.length - 1; i++) {
        String w1 = words[i];
        String w2 = words[i + 1];
        int minLen = Math.min(w1.length(), w2.length());
        //abcd , abc
        if(w1.length() > w2.length() && w1.substring(0,minLen).equals(w2.substring(0,minLen))) {
            return "";
        }
        for(int j = 0; j < minLen; j++) {
            //find indiff char - wrt wrf
            if(w1.charAt(j) != w2.charAt(j)) {
                //build graph
                if( !adj.get(w1.charAt(j)).contains(w2.charAt(j))) {
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    indegree.put(w2.charAt(j), indegree.get(w2.charAt(j)) + 1);
                }
                break;
            }
        }
    }
    StringBuilder res = new StringBuilder();
    Queue<Character> q = new LinkedList<>();
    for(char c : indegree.keySet()){
        if(indegree.get(c) == 0){
            q.add(c);
        }
    }
    while(!q.isEmpty()) {
        char vertex = q.poll();
        res.append(vertex);
        for(char nei : adj.get(vertex)) {
            indegree.put(nei, indegree.get(nei) - 1);
            if(indegree.get(nei) == 0) {
                q.add(nei);
            }
        }
    }
    //still some vertex with indegree 1 or > left so res len will be less[cycle and invalid dict]
    if(res.length() != indegree.size() ){
        return "";
    }
    return res.toString();
    }
}
