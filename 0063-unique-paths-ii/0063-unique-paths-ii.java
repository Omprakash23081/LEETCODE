class Solution {
    public int uniquePathsWithObstacles(int[][] arr) {
        if(arr[0][0] == 1 || arr[arr.length-1][arr[0].length-1] == 1) return 0;
        boolean visited[][] = new boolean[arr.length][arr[0].length];
        return optmil_solve(arr);
    }

    int solve(int arr[][] , int i , int j , boolean visited[][]){
        int m = arr.length;
        int n = arr[0].length;
        if(i == m-1 && j == n-1) return 1;
        if(i >= m || j>= n || i< 0 || j<0) return 0;
        if(visited[i][j]) return 0;
        if(arr[i][j] == 1) return 0;

        visited[i][j] = true;

        int c1 = solve(arr , i+1 , j , visited);
        int c2 = solve(arr , i , j+1 , visited);

        return c1+c2;
    }

    int optmil_solve(int arr[][]){
        int m = arr.length;
        int n = arr[0].length;
        int dp[][] = new int[m+1][n+1];

        // for(int i = 0 ; i<= m ; i++) dp[i][0] = 1;

        // for(int i = 0 ; i<= n ; i++) dp[0][i] = 1;

        dp[1][1] = 1;

        for(int i = 1 ; i<=m ; i++){
            for(int j = 1 ; j<=n ; j++){
                if(arr[i-1][j-1] != 1){
                    dp[i][j] += dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}