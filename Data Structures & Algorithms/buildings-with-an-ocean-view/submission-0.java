class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> st = new Stack<>();
        for( int i= heights.length -1 ; i>=0;i--){
            if(st.isEmpty()){
                st.push(i);
                continue;
            }
            if(heights[i] > heights[st.peek()]){
                st.push(i);
            }
        }
        int n =st.size();
        int[] ans = new int[st.size()];
        for(int i =0;i<n;i++){
            ans[i] = st.pop();
        }
        return ans;
    }
}