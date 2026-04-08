class Solution {
    static final int MOD = 1_000_000_007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;

        long[] mul = new long[n];
        for (int i = 0; i < n; i++) {
            mul[i] = 1;
        }

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int k = q[2];
            int v = q[3];

            for (int i = l; i <= r; i += k) {
                mul[i] = (mul[i] * v) % MOD;
            }
        }

        long xor = 0;

        for (int i = 0; i < n; i++) {
            long val = (nums[i] * mul[i]) % MOD;
            xor ^= val;
        }

        return (int) xor;
    }
}