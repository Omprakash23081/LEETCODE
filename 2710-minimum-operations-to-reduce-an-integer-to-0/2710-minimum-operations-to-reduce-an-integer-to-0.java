class Solution {

    private int solve(int n) {
       if(n==0 || n==1) return n; 

       int temp = 1;
       while(temp*2<n) temp *= 2;

       return 1+ Math.min(solve(temp*2-n) , solve(n-temp));
    }

    public int minOperations(int n) {
        return solve(n);
    }
}
