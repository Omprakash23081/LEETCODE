class Solution {
    public boolean hasAlternatingBits(int n) {
        long bit  = 1;
        boolean flag = (n & bit) > 0 ? true : false; 
        bit = bit<<1;
        while(bit<=n){
            if(flag && (bit & n )!= 0) return false;
            else if(!flag && (bit & n) == 0)return false;
            bit = bit<<1;
            flag = !flag;
        }
        return true;
    } 
}