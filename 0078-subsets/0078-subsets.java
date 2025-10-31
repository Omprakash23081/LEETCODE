class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> li = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        getSubSequence(li, temp, 0, nums);
        return li;
    }

    private void getSubSequence(List<List<Integer>> li, List<Integer> temp, int i, int[] nums) {
        if (i == nums.length) {
            li.add(new ArrayList<>(temp));
            temp = new ArrayList<>();
            return;
        }
        temp.add(nums[i]);
        getSubSequence(li, temp, i + 1, nums);
        temp.remove(temp.size()-1);
        getSubSequence(li, temp, i + 1, nums);
    }
}