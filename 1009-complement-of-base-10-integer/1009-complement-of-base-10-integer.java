class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
        long mas = 1;
        while(mas <= n){
            mas *= 2;
        }
        return (int)mas-n-1;
    }
}