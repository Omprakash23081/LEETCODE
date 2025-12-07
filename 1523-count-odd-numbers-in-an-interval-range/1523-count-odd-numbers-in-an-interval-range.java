class Solution {
    public int countOdds(int low, int high) {
        low--;
        int res=  0;
        res = (high%2 == 0) ? high/2 : (high+1)/2;
        res -= (low%2 == 0) ? low/2 : (low+1)/2;
        return res; 
    }
}