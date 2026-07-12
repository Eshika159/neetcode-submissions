class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int resLen = 0, resIdx = 0;

        for (int i = 0; i < n; i++) {

            //odd length
            int l =i , r = i;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if( r - l + 1 > resLen) {
                    resLen = r - l + 1;
                    resIdx = l;
                }
                l--;
                r++;
            }
            //even len
            l = i; r = i + 1;
            while(l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                if( r - l + 1 > resLen) {
                    resLen = r - l + 1;
                    resIdx = l;
                }
                l--;
                r++;
            }
        }
        return s.substring(resIdx, resIdx + resLen);
    }
}
