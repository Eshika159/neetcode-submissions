class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb=new StringBuilder();
        for(String s : strs){
            // encode like 5#abcdd
            sb.append(s.length()+"#"+s);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        // decode 5#abcde2#aa -> 
        List<String> l=new ArrayList<>();
        int i = 0;
        while( i < str.length()) {
            int j=i;
            while(str.charAt(j) != '#'){
                j+=1;
            }
            
            int length =  Integer.parseInt(str.substring(i,j));
            
            i = j+1; //start of abcde
            j= i+ length;
            l.add(str.substring(i,j));
            i=j; //now i at next length int

        }
        return l;

    }
}
