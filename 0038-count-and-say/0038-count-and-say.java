class Solution {
    public String countAndSay(int n) {
        return solve(n);
    }

    String solve(int n){
        if(n == 1) return "1";
  
        String s = solve(n-1); 
        
        StringBuilder newString = new StringBuilder();
        int ln = s.length();
        for(int i = 0 ; i< ln ; i++){
            int count = 0;
            char ch = s.charAt(i);
            while(i<ln && s.charAt(i)==ch){
                count++;
                i++;
            }
            newString.append(count);
            newString.append(ch);
            i--;
        }
        return newString.toString();
    }
}