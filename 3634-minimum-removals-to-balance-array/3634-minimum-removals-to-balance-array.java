class Solution {
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = Integer.MAX_VALUE;
        int idx = n-1;
        int left = n-2;

        while(idx>=0 && left >=0 && idx >= left){
            if((long)nums[left]*k < nums[idx]) idx--;
            else if((long)nums[left]*k >= nums[idx]){
                int right = (n-(idx+1));
                max = Math.min(max , left+right);
                left--;
            } 
        } 
        
        return max >= n ? 0 : max;
    }
}
