class Solution {

    int[][] dp;
    int[] suffix;

    public int stoneGameII(int[] piles) {
        int n = piles.length;

        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return solve(piles, 0, 1);
    }

    int solve(int[] arr, int idx, int M) {

        if (idx >= arr.length) {
            return 0;
        }

        if (idx + 2 * M >= arr.length) {
            return suffix[idx];
        }

        if (dp[idx][M] != 0) {
            return dp[idx][M];
        }

        int opponentMin = Integer.MAX_VALUE;

        for (int x = 1; x <= 2 * M; x++) {

            int newM = Math.max(M, x);

            int opponent = solve(arr, idx + x, newM);

            opponentMin = Math.min(opponentMin, opponent);
        }

        int result = suffix[idx] - opponentMin;

        dp[idx][M] = result;

        return result;
    }
}