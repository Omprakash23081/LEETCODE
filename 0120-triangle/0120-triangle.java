class Solution {
    Integer dp[][];
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        dp = new Integer[size][triangle.get(size-1).size()];
        return solve(triangle , 0 , 0);
    }

    int solve(List<List<Integer>> li , int idx , int j){
        if(idx >= li.size()) return 0;

        if(dp[idx][j] != null) return dp[idx][j];

        int t = 0;
        int min = Integer.MAX_VALUE;
        int size = li.get(idx).size();

        for(int i = j ; i< j+2 && i < size ; i++){

            int v = li.get(idx).get(i);
            t = v + solve(li , idx+1 , i);
            min = Math.min(t , min);
            t -= v;

        }

        return dp[idx][j] = min;
    }
}