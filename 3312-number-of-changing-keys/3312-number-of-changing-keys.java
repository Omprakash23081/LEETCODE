class Solution {
    public int countKeyChanges(String s) {
        int count  = 0;
        for(int i= 0 ; i<s.length()-1 ; i++){
            char ch1 = s.charAt(i) ;
            char ch2 = s.charAt(i+1) ;
            if(ch1>=65 && ch1<=90) ch1 = (char)(ch1 + 32);
            if(ch2>=65 && ch2<=90) ch2 = (char)(ch2 + 32);
            if(ch1 != ch2) count++;
        }
        return count;
    }
}