class Solution {
    public int maximalSquare(char[][] arr) {
        int ans = 0;
        int m = arr.length;
        int n = arr[0].length;

        int dp[][] = new int[m+1][n+1];

        for(int i = 1; i<= m; i++){
            for(int j = 1; j<=n; j++){
                if(arr[i-1][j-1] == '1'){
                    dp[i][j] = 1 + Math.min(dp[i-1][j] , Math.min(dp[i][j-1] , dp[i-1][j-1]));
                }
                ans = Math.max(ans , dp[i][j]);
            }
        }

        // for(int a[] : dp){
        //     for(int v :a)System.out.print(v+" ");
        //     System.out.println();
        // }

        return ans*ans;
    }
}