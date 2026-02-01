class Solution {
    public int minimumCost(int[] nums) {
        int res = nums[0];
        int min = 51;
        int secondMin = 51;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                secondMin = min;
                min = nums[i];
            } else if (nums[i] < secondMin)
                secondMin = nums[i];
        }
        res += (min + secondMin);
        return res;
    }
}