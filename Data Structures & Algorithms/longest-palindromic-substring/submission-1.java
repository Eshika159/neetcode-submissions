class Solution {
    public String longestPalindrome(String s) {
        int reslen = 0, residx = 0;

        //treat every char as center and expand
        for(int i = 0; i < s.length(); i++) {
            //odd len
            int l = i, r = i;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if(r - l + 1 > reslen) {
                    residx = l;
                    reslen = r - l + 1;
                }
                l--;
                r++;
            }
            //even
            l = i; r = i + 1;
            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if( r - l + 1 > reslen) {
                    residx = l;
                    reslen = r - l + 1;
                }
                l--; r++;
            }
        }
        return s.substring(residx, residx + reslen);
    }
}
