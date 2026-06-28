class MinStack {
    Stack<Long>st =new Stack<>();
    long min;
    public MinStack() {
      
    }
    
    public void push(int val) {
        if(st.size()==0){
            st.push((long)val);
            min=val;
        }
        else if(val>=min){
            st.push((long)val);
        }
        else{
            st.push((long)(2L*val-min));
            min=val;
        }
    }
    
    public void pop() {
        long top=st.pop();
        if(min>top){
            min=2*min-top;
        }
    }
    
    public int top() {
        long top=st.peek();
        if(top>=min){
            return (int)top;
        }
            return (int) min;
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */