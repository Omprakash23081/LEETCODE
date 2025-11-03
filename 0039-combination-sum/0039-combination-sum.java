class Solution {
    List<List<Integer>> li = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> temp = new ArrayList<>();
        helper(candidates, target, temp, 0, 0);
        return li;
    }

    private void helper(int[] candidates, int target, List<Integer> temp, int sum, int idx) {
        if (sum == target) {
            li.add(new ArrayList<>(temp));
            return;
        }
        if (sum > target || idx == candidates.length)
            return;

        temp.add(candidates[idx]);
        helper(candidates, target, temp, sum + candidates[idx], idx);
        temp.remove(temp.size() - 1);
        helper(candidates, target, temp, sum, idx + 1);
    }
}