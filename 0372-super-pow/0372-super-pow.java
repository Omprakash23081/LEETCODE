class Solution {
    int MOD = 1337;

    int modPow(int base, int exp) {
        int ans = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) ans = ans * base % MOD;
            base = base * base % MOD;
            exp /= 2;
        }
        return ans;
    }

    public int superPow(int a, int[] b) {
        int result = 1;
        for (int digit : b) {
            result = (modPow(result, 10) * modPow(a, digit)) % MOD;
        }
        return result;
    }
}
