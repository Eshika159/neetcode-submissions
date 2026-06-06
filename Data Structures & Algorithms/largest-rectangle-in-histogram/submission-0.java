class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> st = new Stack<>();
        for(int i = 0;i < heights.length; i++) {
            int start = i;
            //when current i height is < st top element-> pop
            while(!st.isEmpty() && heights[i] < st.peek()[1]) {
                int[] top = st.pop();
                int idxTop = top[0];
                int h = top[1];
                maxArea = Math.max(maxArea, (i - idxTop) * h ); 
                start = idxTop;
            }
            st.push( new int[]{start, heights[i]});
        }
        //for remianing stack elements
        for(int[] pair : st) {
            int i = pair[0];
            int hei = pair[1];
            maxArea = Math.max(maxArea,hei * (heights.length - i));
        }
        return maxArea;

    }
}
