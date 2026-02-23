class Solution {
    int row;
    int MOD = 1000000007;
    List<String> li;
    Integer dp[][];

    public int colorTheGrid(int m, int n) {

        row = m;
        li = new ArrayList<>();
        combination(new StringBuilder());

        dp = new Integer[n][li.size()];

        int res = 0;

        for(int i = 0; i < li.size(); i++){
            res = (res + solve(n - 1, i)) % MOD;
        }

        return res;
    }

    int solve(int rem, int prevState){

        if(rem == 0) return 1;

        if(dp[rem][prevState] != null)
            return dp[rem][prevState];

        String prev = li.get(prevState);

        int ways = 0;

        for(int i = 0; i < li.size(); i++){

            String curr = li.get(i);
            boolean valid = true;

            for(int j = 0; j < row; j++){
                if(prev.charAt(j) == curr.charAt(j)){
                    valid = false;
                    break;
                }
            }

            if(valid){
                ways = (ways + solve(rem - 1, i)) % MOD;
            }
        }

        return dp[rem][prevState] = ways;
    }

    void combination(StringBuilder s){

        if(s.length() == row){
            li.add(s.toString());
            return;
        }

        for(char ch : new char[]{'r','g','b'}){
            if(s.length() == 0 || s.charAt(s.length()-1) != ch){
                s.append(ch);
                combination(s);
                s.deleteCharAt(s.length()-1);
            }
        }
    }
}