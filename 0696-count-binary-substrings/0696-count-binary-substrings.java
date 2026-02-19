class Solution {
    public int countBinarySubstrings(String s) {
        int zero = 0;
        int one = 0;
        int res = 0;
        for(int i =0 ; i<s.length()-1 ; i++){
            if(s.charAt(i)=='1')one++;
            else zero++;   
            if(s.charAt(i) != s.charAt(i+1) && zero != 0 && one != 0){
                res += Math.min(zero , one);
                if(s.charAt(i)=='0')one = 0;
                else zero = 0; 
            }
        }
        if(s.charAt(s.length()-1)=='0')zero++;
        else one++;
        
        res += Math.min(zero , one);
        return res;
    }
}