class Solution {
    public int countPartitions(int[] nums) {
        int sum = 0;
        for(int v : nums) sum += v;

        int res =0;
        int temp =0;
        for(int i=0 ; i<nums.length-1 ; i++){
            temp += nums[i];
            if((temp - (sum-temp))%2==0)res++;
        }
        return res;
    }
}