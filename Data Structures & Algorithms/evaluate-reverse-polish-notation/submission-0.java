class Solution {
    public int evalRPN(String[] token) {
        Stack <Integer> st=new Stack<>();
        for(int i=0 ; i<token.length ;i++){
            if (token[i].equals("+")) {
                st.push(st.pop() + st.pop());
            }
            else if (token[i].equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b-a);
            }
            else if (token[i].equals("*")){
                st.push(st.pop() * st.pop());
            }
               else if (token[i].equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b/a);
            }
            else {
                st.push (Integer.parseInt(token[i]));
            }
        }
        return st.pop();
    }
}
