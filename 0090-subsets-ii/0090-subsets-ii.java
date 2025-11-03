class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> li = new ArrayList<>();
        dfs(nums ,res , li ,0);
        return res;
    }
    private void dfs(int arr[] , List<List<Integer>>res , List<Integer> li , int idx){
        res.add(new ArrayList<>(li));

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;
            li.add(arr[i]);
            dfs(arr, res, li, i + 1);
            li.remove(li.size() - 1);
        }
    }
}