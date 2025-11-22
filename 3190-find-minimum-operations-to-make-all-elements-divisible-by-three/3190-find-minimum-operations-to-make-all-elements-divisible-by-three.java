class Solution {
    public int minimumOperations(int[] nums) {
        int res =0;
        for(int v : nums) res += Math.min(v%3 , 3-(v%3));
        return res;
    }
}