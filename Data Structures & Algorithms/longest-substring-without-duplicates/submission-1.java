class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0 , r = 0, res = 0;
        //zxyzxyz
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        for(r = 0; r < n; r++){
            while(set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            res= Math.max(res, r - l + 1);
        }
        return res;
    }
}
