class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lt = new ArrayList<>();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] op = s.toCharArray();
            Arrays.sort(op);
            String n = new String(op);
            if(map.containsKey(n)){
                map.get(n).add(s);
            } else {
                map.put(n, new ArrayList<>());
                map.get(n).add(s);
            }
        }
        map.forEach((key, value) -> {
            lt.add(value);
        });
        return lt;
    }
}
