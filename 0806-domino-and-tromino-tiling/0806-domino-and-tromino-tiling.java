class Solution {
    int mod = 1000000007;

    public int numTilings(int n) {
        Integer[][] dp = new Integer[n + 1][n + 1];
        return solve(n, n, dp);
    }

    private int solve(int r1, int r2, Integer[][] dp) {

        if (r1 == 0 && r2 == 0) return 1;

        if (r1 < 0 || r2 < 0 || Math.abs(r1 - r2) > 1) return 0;

        if (dp[r1][r2] != null) return dp[r1][r2];

        long count = 0;

        if (r1 == r2) {  
            count += solve(r1 - 1, r2 - 1, dp);  
            count += solve(r1 - 2, r2 - 2, dp);  
            count += solve(r1 - 1, r2 - 2, dp);  
            count += solve(r1 - 2, r2 - 1, dp);  
        }

        else if (r1 < r2) { 
            count += solve(r1 - 1, r2 - 1, dp);
            count += solve(r1 - 1, r2 - 2, dp);
        }

        else { 
            count += solve(r1 - 1, r2 - 1, dp);
            count += solve(r1 - 2, r2 - 1, dp);
        }

        return dp[r1][r2] = (int)(count % mod);
    }
}
