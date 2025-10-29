class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int count = 0;
        for(int i = 0 ; i<nums.length-pattern.length ; i++){
            if(solve(nums , pattern , i)) count++;
        }
        return count;
    }
    private boolean solve(int nums[] , int[] arr , int start){
        int k = 0;
        for(int i = start ; i <start + arr.length ; i++){
            if(arr[k]==1 && nums[i+1]<=nums[i]) return false;
            else if(arr[k]==0 && nums[i+1]!=nums[i]) return false;
            else if(arr[k]== -1 && nums[i+1]>=nums[i]) return false;
            k++;
        }
        return true;
    }

}