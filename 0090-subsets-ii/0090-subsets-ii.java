class Solution {
    // boolean visited[];
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> li = new HashSet<>();
        solve(li , nums , 0, new ArrayList<>());
        return new ArrayList<>(li);
    }

    void solve(Set<List<Integer>> li , int nums[] , int idx , List<Integer> res){
        if(idx >= nums.length) {
            List<Integer> temp = new ArrayList<>(res);
            temp.sort(null);
            li.add(new ArrayList<>(temp));
            return;
        }
        // if(visited[idx]) return;

        // visited[idx] = true;
        res.add(nums[idx]);
        solve(li , nums , idx+1 , res);
        if(res.size() > 0)
            res.remove(res.size()-1);
        solve(li , nums , idx+1 , res);
        // visited[idx] = false;
    }
}