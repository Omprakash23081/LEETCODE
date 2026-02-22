class Solution {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        int max = 0;
        int idx = -1;
        for(int i =0 ; i<s.length() ; i++){
            if(s.charAt(i)=='1') {
                if(idx > -1)
                    max = Math.max(max , i-idx);
                idx = i;    
            }    
        }
        return max;
    }
}