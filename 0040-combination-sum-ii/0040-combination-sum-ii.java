class Solution {
    List<List<Integer>> li = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<>(), 0);
        return li;
    }

    private void helper(int[] candidates, int target, List<Integer> temp, int idx) {
        if (target == 0) {
            li.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) return;

        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;

            temp.add(candidates[i]);
            helper(candidates, target - candidates[i], temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}

// class Solution {
//     Set<List<Integer>> li = new HashSet<>();
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         Arrays.sort(candidates);
//         List<Integer> temp = new ArrayList<>();
//         helper(candidates, target, temp, 0, 0);
//         List<List<Integer>> lis = new ArrayList<>(li);
//         return lis;
//     }
//     private void helper(int[] candidates, int target, List<Integer> temp, int sum, int idx){
//         if (sum == target) {
//             li.add(new ArrayList<>(temp));
//             return;
//         }
//         if (sum > target || idx == candidates.length)
//             return;
//         temp.add(candidates[idx]);  
//         helper(candidates, target, temp, sum + candidates[idx], idx+1);
//         temp.remove(temp.size() - 1);
//         while(temp.size()>0 && candidates[idx]==temp.get(temp.size()-1)){ 
//             idx++;
//             if(idx>=candidates.length)return;
//         }    
//         helper(candidates, target, temp, sum, idx + 1);    
//     }  
// }