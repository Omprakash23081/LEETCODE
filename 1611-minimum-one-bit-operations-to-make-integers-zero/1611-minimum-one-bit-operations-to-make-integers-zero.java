class Solution {
    public int minimumOneBitOperations(int n) {
        int bit = 0;
        while(n>0){
            bit ^= n;
            n = n>>1;
        }
        return bit;
    }
}