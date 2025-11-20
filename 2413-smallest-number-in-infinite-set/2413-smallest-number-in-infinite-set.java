class SmallestInfiniteSet {
    int count ;
    Queue<Integer> qu;
    int arr[];
    public SmallestInfiniteSet() {
        count = 1;
        qu = new PriorityQueue<>();
        arr = new int[1001];
    }
    
    public int popSmallest() {
        if(!qu.isEmpty() && qu.peek()<=count){
            arr[qu.peek()]=0;
            return qu.poll();
        }else{
            return count++;
        }
    }
    
    public void addBack(int num) {
        if(count<=num) return ;
        if(qu.isEmpty() || arr[num]==0){
            qu.add(num);
            arr[num]++;
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */