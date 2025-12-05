class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length , res = 0;
        int j =0;
        for(int i=1 ; i<n ; i++){
           if(i>=2 && nums[i]==nums[i-1] && nums[i-1]==nums[i-2]){
              int temp = nums[i];
              while(i<n && nums[i]==temp) nums[i++]=1000000;
           }   
        }

        for(int i=0 ; i<n ; i++){
            if(nums[i] == 1000000) continue;
            nums[j++] = nums[i];
            res++;
        }

        return res;
    }
} 