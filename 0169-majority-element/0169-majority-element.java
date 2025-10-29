class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        int maxCount =0;
        int res =0;
        for(int i =0 ; i<nums.length ; i++){
            int count = map.getOrDefault(nums[i] , 0)+1 ;
            map.put(nums[i] , count);
            if(count>maxCount) {
                res = nums[i];
                maxCount =count;
            }   
        }
        return res;
    }
}