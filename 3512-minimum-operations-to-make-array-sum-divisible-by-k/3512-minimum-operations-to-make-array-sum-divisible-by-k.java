class Solution {
    public int minOperations(int[] nums, int k) {
        int sum =0;
        for(int v : nums)sum += v;
        int count =0;
        while(sum%k!=0){
            sum--;
            count++;
        }
        return count;
    }
}