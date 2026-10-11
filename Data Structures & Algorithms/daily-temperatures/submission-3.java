class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> st = new Stack<>(); // pair: temp, index
        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            //warmer temp came so pop
            while(!st.isEmpty() && t > st.peek()[0]){
                int[] pair = st.pop();
                res[pair[1]] = i - pair[1]; //days took for warmer day
            }
            st.push(new int[]{t, i}); //push small temp till we find
        }
        return res;
    }
}
