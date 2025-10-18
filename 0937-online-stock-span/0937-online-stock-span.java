class StockSpanner {
    // Node head;
    Stack<Integer> st;
    Stack<Integer> count;
    public StockSpanner() {
        st = new Stack<>();
        count = new Stack<>();
    }
    
    
    public int next(int price) {
        // if(head==null) {
        //     head = new Node(price , null , 1);
        //     return 1;
        // }else{
        //     int min = (head.val <= price) ? head.minCount + 1 : 1 ; 
        //     head = new Node(price , head  , min);
        //     return min;
        // }
        if(st.isEmpty() || st.peek()> price){
            st.push(price);
            count.push(1);
            return 1;
        }else{
            int min = 0;
            while(!st.isEmpty() && st.peek()<= price){
                st.pop();
                min += count.pop();
            }
            st.push(price);
            count.push(min+1);
            return count.peek();
        }
    }
}

// class Node{
//     int val;
//     Node next;
//     int minCount;
//     Node(int val , Node next , int minCount){
//         this.val = val;
//         this.next = next;
//         this.minCount = minCount;
//     }
// }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */