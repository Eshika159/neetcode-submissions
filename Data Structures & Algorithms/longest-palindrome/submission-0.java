class Solution {
    public int longestPalindrome(String s) {
        int res = 0;
        Map<Character,Integer> count = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i),count.getOrDefault(s.charAt(i),0)+1);
            if(count.get(s.charAt(i)) % 2 == 0) {
                res+= 2;
            }
        }
        for(int cnt : count.values()) {
            if(cnt % 2 == 1){
                res+=1;
                break;
            }
        }
        return res;
    }
}