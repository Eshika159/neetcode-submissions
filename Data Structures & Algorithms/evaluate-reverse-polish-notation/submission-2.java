class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(String s : tokens) {
            if(s.equals("+")) {
                int sec = st.pop();
                int first = st.pop();
                st.push(sec + first);
            } else if (s.equals("*")){
                st.push(st.pop() * st.pop());
            } else if(s.equals("-")) {
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            } else if ( s.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            } else {
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}
