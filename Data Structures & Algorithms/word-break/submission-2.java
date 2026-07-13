class Solution {
    private Boolean dp[];
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        return dfs(s,0,wordDict);
    }
    private boolean dfs(String s , int i , List<String> wordDict) {
        if( i == s.length())
            return true;
        //already done
        if(dp[i] != null){
            return dp[i];
        }
        for(String word : wordDict) {
            if(i + word.length() <=s.length() && s.substring(i, i+ word.length()).equals(word)) {
               if(dfs(s, i + word.length(), wordDict)) {
                dp[i] = true;
                return true;
               }
            }
        }
        dp[i] = false;
        return false;
    }
}
