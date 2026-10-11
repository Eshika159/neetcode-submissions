class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        //decreasing order of position
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> st = new Stack<>();
        for(int[] p : pair) {
            //position/speed = time
            st.push((double) (target- p[0])/p[1]);
            if(st.size() >=2 && st.peek() <= st.get(st.size() - 2)){
                st.pop(); //pop faster one 
            }
        }
        return st.size();
    }
}
