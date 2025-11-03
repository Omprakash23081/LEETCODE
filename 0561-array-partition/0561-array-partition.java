class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res =0 , n= nums.length;
        for(int i =0 ; i<n - 1 ; i+=2){
            res += Math.min(nums[i] , nums[i+1]);
        }
        return res;
    }
}