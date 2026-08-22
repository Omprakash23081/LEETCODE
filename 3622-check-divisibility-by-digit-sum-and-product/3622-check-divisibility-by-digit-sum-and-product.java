class Solution {
    public boolean checkDivisibility(int n) {
        long sum = 0;
        long pro = 1;
        int t = n;

        while(n > 0){
            int mod = n%10;
            sum += mod;
            pro *= mod;
            n /=10;
        }

        return t%(sum+pro) == 0;
    }
}