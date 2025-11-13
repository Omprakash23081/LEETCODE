class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        Integer arr[] = new Integer[n+1];
        return  Math.min(helper(cost , arr ,0) , helper(cost , arr ,1)); 
    }
    private int helper(int cost[] , Integer arr[] , int idx ){
        if(idx >= cost.length)return 0;
        if(arr[idx]!=null)return arr[idx];
        int r1 = cost[idx] + helper(cost , arr , idx+1);
        int r2 = cost[idx] + helper(cost , arr, idx+2);
        return arr[idx]= Math.min(r1 , r2);
    }
}