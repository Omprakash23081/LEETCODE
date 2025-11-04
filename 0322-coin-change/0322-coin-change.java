class Solution {
    public int coinChange(int[] coins, int amount) {
        Integer dp[] = new Integer[amount + 1]; // dp by amount
        return dfs(coins, dp, amount);
    }

    private int dfs(int[] coins, Integer[] dp, int amount) {
        if (amount == 0) return 0;
        if (dp[amount] != null) return dp[amount];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int res = dfs(coins, dp, amount - coin);
                if (res != -1) {
                    min = Math.min(min, 1 + res);
                }
            }
        }

        dp[amount] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amount];
    }
}
