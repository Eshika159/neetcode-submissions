class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        //meet means - opposite , then smaller pop , if same both pop
        //insert when same signs
        for(int a : asteroids) {
           while(!st.isEmpty() && a < 0 && st.peek() > 0) {
            //colliding st is pos and incoming a <0 so keep on destroying
            int diff = a + st.peek();
            // 3 =st(pop) and -5 = a => -2
            if(diff < 0){
                st.pop();
            } else if (diff > 0){
                a = 0;
            } else { //same size
                a = 0;
                st.pop();
            }
           }
           //same direction
           if ( a != 0) {
            st.add(a);
           }
        }
        return st.stream().mapToInt(i -> i).toArray();
    }
}