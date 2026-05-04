class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int [] a=new int[26];
        Arrays.fill(a, 0);
        char [] cha=s1.toCharArray();
        for(char ch :cha){
            a[ch - 'a']++;
        }
        int j=0,i=0,total_chars=s1.length();
        while(j< s2.length()){
            if(a[s2.charAt(j++) - 'a']-- > 0){
                total_chars--;
            }
            if(total_chars == 0) return true;
            if(j-i == s1.length() && a[s2.charAt(i++) - 'a']++ >=0 ){
                total_chars++;
            }
        }
        return false;

    }
}
