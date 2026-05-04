class Solution {
    public boolean isAnagram(String s, String t) {
       
        Map<Character,Integer> map = new HashMap<>();
        if(s.length()!= t.length()) {
            return false;
        }
        for(char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c : t.toCharArray()) {
            //if a new char in t return null
            // if count of char is diff then already reached s count
            if (map.get(c) == null || map.get(c) == 0) {
                return false;

            }
            map.put(c,map.get(c)-1);

        }
        return true;

    }
}
