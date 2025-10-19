class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;

        for (int v : nums) {
            if (map.containsKey(v)) continue;
            int left = map.getOrDefault(v - 1, 0);
            int right = map.getOrDefault(v + 1, 0);
            int sum = left + right + 1;
            map.put(v, sum);

            map.put(v - left, sum);
            map.put(v + right, sum);

            max = Math.max(max, sum);
        }

        return max;
    }
}
