class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        Queue<Character> que = new LinkedList<>();
        int max = 0;
        for (char v : s.toCharArray()) {
            if (set.add(v)) {
                que.offer(v);
            } else {
                while (!que.isEmpty() && que.peek() != v) {
                    set.remove(que.poll());
                }
                que.poll();
                que.offer(v);
            }
            max = Math.max(max, que.size());
        }
        return max;
    }
}