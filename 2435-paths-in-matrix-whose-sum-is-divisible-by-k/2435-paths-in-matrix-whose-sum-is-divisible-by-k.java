class Solution {
    Integer[][][] dp;
    int n, m, k;

    public int numberOfPaths(int[][] grid, int k) {
        this.k = k;
        n = grid.length;
        m = grid[0].length;

        dp = new Integer[n][m][k];
        return dfs(grid , 0, 0, 0);
    }

    private int dfs(int grid[][] , int i, int j, int mod) {
        if (i == n || j == m) return 0;

        mod = (mod + grid[i][j]) % k;

        if (i == n - 1 && j == m - 1)
            return mod == 0 ? 1 : 0;

        if (dp[i][j][mod] != null)
            return dp[i][j][mod];

        int right = dfs(grid,i, j + 1, mod);
        int down = dfs(grid, i + 1, j, mod);

        return dp[i][j][mod] = (right + down)%1000000007;
    }
}
