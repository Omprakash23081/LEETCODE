class Solution {
    Integer dp[] ;
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        dp  = new Integer[nums.length];
        int first  = solve(nums , 0 , nums.length-1);
        dp = new Integer[nums.length];
        int second = solve(nums , 1 , nums.length);
        return Math.max(first , second);
    }

    int solve(int nums[] , int idx , int n){
        if(idx >= n) return 0;

        if(dp[idx] != null) return dp[idx];

        int take = nums[idx] + solve(nums , idx+2 , n);
        int notTake = solve(nums, idx+1 , n);

        return  dp[idx] = Math.max(take , notTake);
    }
}