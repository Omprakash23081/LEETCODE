class Solution {
    Integer dp[];
    public int rob(int[] nums) {
        dp = new Integer[nums.length];
        return Math.max(solve(nums , 0) , solve(nums , 1));
    }

    int solve(int nums[] , int idx){
        if(idx >= nums.length) return 0;

        if(dp[idx] != null) return dp[idx];

        int take = nums[idx] + solve(nums , idx+2);
        int notTake = solve(nums, idx+1);

        return dp[idx] = Math.max(take , notTake);
    }
}