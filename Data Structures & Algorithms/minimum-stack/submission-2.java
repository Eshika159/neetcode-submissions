class MinStack {
    private Stack<Integer> st;
    private Stack<Integer> minst;

    public MinStack() {
        st = new Stack<Integer>();
        minst = new Stack<Integer>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minst.isEmpty() || val <= minst.peek()) {
            minst.push(val);
        }
    }
    
    public void pop() {
        if(st.isEmpty()) return;
        int top = st.pop();
        if(top == minst.peek()) {
            minst.pop();
        }
        
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minst.peek();
    }
}
