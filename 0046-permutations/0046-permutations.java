class Solution {
    List<List<Integer>> li = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        boolean arr1[] = new boolean[nums.length];
        permutations(nums, arr1, temp);
        return li;
    }

    private void permutations(int arr[], boolean arr1[], List<Integer> temp) {
        if (temp.size() == arr.length) {
            li.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < arr.length; i++) {
            if (!arr1[i]) {
                temp.add(arr[i]);
                arr1[i] = true;
                permutations(arr, arr1, temp);
                arr1[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}