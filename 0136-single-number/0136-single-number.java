class Solution {
    public int singleNumber(int[] nums) {
        // Map<Integer , Integer> map = new HashMap<>();
        // for(int v :nums){
        //     map.put(v , map.getOrDefault(v , 0)+1);
        // }
        // for(int v : map.keySet()){
        //     if(map.get(v)==1) return v;
        // }
        // return 0;
        // for(int i=0;i<nums.length ; i++){
        //     int count =0;
        //     for(int v:nums){
        //         if(v==nums[i]) count++;
        //         if(count>2) break;
        //     }
        //     if(count==1) return nums[i];
        // }
        int result = 0;
        for (int num : nums) {
            result ^= num; 
        }
        return result;

    }
}