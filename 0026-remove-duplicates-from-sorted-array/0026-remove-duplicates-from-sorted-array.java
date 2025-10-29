class Solution {
    public int removeDuplicates(int[] nums) { 
        // Set<Integer> st = new HashSet<>();
        int j =1;
        int prives = nums[0];
        // for(int v : nums){
        //     if(st.add(v)){
        //         nums[i++] = v;
        //     }
        // }
        for(int i =1 ; i<nums.length; i++){
            if(prives<nums[i]){
                nums[j++]=nums[i];
                prives=nums[i];
            }
        }
        return j;
    }
}