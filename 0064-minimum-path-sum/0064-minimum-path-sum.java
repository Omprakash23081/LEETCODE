class Solution {
    public int minPathSum(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int dp[][] = new int[n+1][m+1];

        // dp[1][1] = arr[0][0];
        for(int i = 0 ; i<= n ; i++) dp[i][0] = Integer.MAX_VALUE;

        for(int i = 0 ; i<= m ; i++) dp[0][i] = Integer.MAX_VALUE;

        for(int i = 1 ; i<=n ; i++){
            for(int j = 1; j<=m; j++){
                int v = Math.min(dp[i-1][j] , dp[i][j-1]);
                v = (v==Integer.MAX_VALUE ? 0 : v);
                dp[i][j] = arr[i-1][j-1] + v;
            }
        }

        return dp[n][m];
    }
}