class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int v : nums)pq.add(v);
        for(int i =1 ; i<k ; i++)pq.poll();
        return pq.peek();
    }
} 