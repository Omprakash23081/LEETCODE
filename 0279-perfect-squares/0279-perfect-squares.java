class Solution {
    public int numSquares(int n) {
        Integer dp[] = new Integer[n+1];
        return solve(n , dp);
    }

    int solve(int n , Integer dp[]){
        if(n<0)return -1;
        if(n==0)return 0;
        if(dp[n] !=null)return dp[n];
        int min = Integer.MAX_VALUE;
        for(int i= 1 ; i<= Math.pow(n , 0.5) ; i++){
            int res = solve(n-(i*i) , dp);
            if(res !=-1)
                min = Math.min(min , 1+res);
        }
        return dp[n] = min;
    }
} 