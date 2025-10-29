class MyQueue {
    private int arr[] ;
    private static int size;
    private static int start;
    public MyQueue() {
        arr = new int[100];
        size=0;
        start =0;
    }
    
    public void push(int x) {
        arr[size++] = x;
    }
    
    public int pop() {
        int v = arr[start];
        arr[start++] =0;
        return v;
    }
    
    public int peek() {
        return arr[start];
    }
    
    public boolean empty() {
        return size==start;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */