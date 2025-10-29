class Solution {
    public int maxProduct(int[] nums) {
        int prefix=1;
        int res=Integer.MIN_VALUE;
        int sufix = 1;
        for(int i=0 ; i<nums.length ; i++){
            if(sufix==0)sufix=1;
            if(prefix==0)prefix=1;

            prefix = prefix*nums[i];
            sufix = sufix*nums[nums.length-i-1];

            res = Math.max(res , Math.max(sufix , prefix));
        }
        return res;
        // return helper(nums ,0);
    }
    // private int helper(int arr[] , int idx , int prives){
    //     if(idx==arr.length)return 1;
    //     prives = idx;
    //     int take = arr[idx] * helper(arr , idx+1 , prives);
    //     int notTake = helper(arr , idx+1);

    //     return Math.max(take , notTake);
    // }
}