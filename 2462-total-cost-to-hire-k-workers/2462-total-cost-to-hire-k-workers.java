class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int L = 0;
        int R = n - 1;
        for (int i = 0; i < candidates && L <= R; i++) {
            left.add(costs[L++]);
        }

        for (int i = 0; i < candidates && L <= R; i++) {
            right.add(costs[R--]);
        }

        long ans = 0;

        while (k-- > 0) {

            int leftTop = left.isEmpty() ? Integer.MAX_VALUE : left.peek();
            int rightTop = right.isEmpty() ? Integer.MAX_VALUE : right.peek();

            if (leftTop <= rightTop) {
                ans += left.poll();
                if (L <= R) left.add(costs[L++]);
            } else {
                ans += right.poll();
                if (L <= R) right.add(costs[R--]);
            }

        }

        return ans;
    }
}
