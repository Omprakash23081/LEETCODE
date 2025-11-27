class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // For each remainder mod k, store the minimum prefix seen so far
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE);

        long ans = Long.MIN_VALUE;

        for (int j = 0; j <= n; j++) {
            int rem = j % k;

            if (minPrefix[rem] != Long.MAX_VALUE) {
                ans = Math.max(ans, prefix[j] - minPrefix[rem]);
            }

            minPrefix[rem] = Math.min(minPrefix[rem], prefix[j]);
        }

        return ans;
    }
}
