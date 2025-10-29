class Solution {
    public int pivotIndex(int[] nums) {
        int ls=0;
        int rs=0;
        for(int i = 0 ; i<nums.length ; i++){
            rs= rs+nums[i];
        }

        for (int j =0 ; j< nums.length ;j++){
            rs= rs - nums[j];
            if (ls==rs){
               return j ;
            }
            ls = ls+nums[j];
        }
        return -1;
    }
}