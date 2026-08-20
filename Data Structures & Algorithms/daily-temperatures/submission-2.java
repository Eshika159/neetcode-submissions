class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> st = new Stack<>(); // temp, idx

        for (int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while(!st.isEmpty() && t > st.peek()[0]) {
                int[] pair = st.pop();
                res[pair[1]] = i - pair[1];
            }
            st.push(new int[]{t, i});
        }
        return res;
    }
}
