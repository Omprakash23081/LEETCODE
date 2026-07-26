class Solution {
    public int uniquePaths(int m, int n) {
        int arr[][] = new int[m][n];
        boolean visited[][] = new boolean[m][n];
        return optmil_solve(arr);
    }

    int solve(int arr[][] , boolean visited[][] , int i , int j){
        int m = arr.length;
        int n = arr[0].length;
        if(i == m-1 && j == n-1) return 1;
        if(i >= m || j>=n || i<0 || j<0) return 0;
        if(visited[i][j]) return 0;

        visited[i][j] = true;

        int c1 = solve(arr , visited , i+1 , j);
        int c2 = solve(arr , visited , i , j+1);

        visited[i][j] = false;

        return c1+c2;
    }

    int optmil_solve(int arr[][]){
        int m = arr.length;
        int n = arr[0].length;
        int dp[][] = new int[m+1][n+1];
        dp[1][1] = 1;

        for(int i = 1 ; i<=m ; i++){
            for(int j = 1 ; j<=n ; j++){
                dp[i][j] += dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m][n];
    }
}