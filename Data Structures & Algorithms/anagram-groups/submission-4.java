class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++) {
            char[] op = strs[i].toCharArray();
            Arrays.sort(op);
            String n = new String(op);
            if(map.containsKey(n)){
                map.get(n).add(strs[i]); //add in list
            } else {
                map.put(n , new ArrayList<>());
                map.get(n).add(strs[i]);
            }
        }
        map.forEach((key, value) -> {
            res.add(value);
        });
        return res;
    }
}
