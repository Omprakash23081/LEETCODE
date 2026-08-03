class Solution {
    Map<Integer , String> map;
    Integer dp[];
    public int numDecodings(String s) {
        dp = new Integer[s.length()];
        map = new HashMap<>();
        char ch = 'A';

        for(int i = 1 ; i<=26 ; i++){
            map.put(i , ch+"");
            ch++;
        }

      
        return solve(s , 0);
    }

    int solve(String s , int idx){
        if(idx >= s.length()){
            return 1;
        }
        if(s.charAt(idx) == '0') return 0;
        int second = 0;

        if(dp[idx] != null) return dp[idx];

        int first = solve(s , idx+1);
        if(idx+2 <= s.length()){
            String st = s.substring(idx , idx+2);
            int val = Integer.parseInt(st);
            if(val <= 26)
                second = solve(s , idx+2);
        }

        return dp[idx] = first+second;
    }
}