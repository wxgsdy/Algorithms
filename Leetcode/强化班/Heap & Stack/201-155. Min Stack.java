class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> data;
    Stack<Integer> minValues;
    
    public MinStack() {
        data = new Stack<>();
        minValues = new Stack<>();
    }
    
    public void push(int x) {
        data.push(x);
        
        if(minValues.empty()) minValues.push(x);
        else {
            int curt = minValues.peek();
            minValues.push(Math.min(curt, x));
        }      
    }
    
    public void pop() {
        data.pop();
        minValues.pop();
    }
    
    public int top() {
        return data.peek();
    }
    
    public int getMin() {
        return minValues.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */