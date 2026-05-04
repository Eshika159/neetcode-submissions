class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lt=new ArrayList<>();
        Map< String, List<String>> map=new HashMap<>();

        for( String s : strs) {
            //sorted string
            char [] ch= s.toCharArray();
            Arrays.sort(ch);
            String st= new String(ch);

            if(map.containsKey(st)) {
                //add original string
                map.get(st).add(s);
            }
            else {
                map.put(st,new ArrayList<>());
                map.get(st).add(s);
            }
        }
        map.forEach((key,value)-> {
            lt.add(value);
        });

        return lt;
    }
}
