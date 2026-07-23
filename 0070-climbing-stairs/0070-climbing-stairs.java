class Solution {
    public int climbStairs(int n) {
        int arr[] = new int[n+2];
        arr[0] = 0;
        arr[1] = 1;
        int res = 0;
        for(int i = 2 ; i<n+2 ; i++){
            arr[i] = arr[i-1]+arr[i-2];
        }
        return arr[n+1];
    }

    int solve(int n){
        if(n == 0) return 1;
        if(n<0) return 0;

        return solve(n-1) + solve(n-2);
    }
}