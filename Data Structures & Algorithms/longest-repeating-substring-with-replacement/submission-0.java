class Solution {
    public int characterReplacement(String s, int k) {
        
        HashMap<Character,Integer>map=new HashMap<>();
        int res = 0, l = 0, maxf = 0;
        for (int r =0 ; r< s.length(); r++ ) {

            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0)+1);
            
            maxf= Math.max(maxf, map.get(s.charAt(r)));

    // window len - maxfreq element <=k valid window(we can do replacements)
     while( (r-l+1) - maxf > k ) {
            map.put(s.charAt(l),map.get(s.charAt(l))-1);
            l++;
         }
         res = Math.max(res, r-l+1);
        }
        return res;
    }

}
