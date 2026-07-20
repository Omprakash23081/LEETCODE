class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> li = new ArrayList<>();
        solve(li, new ArrayList<>(), k, n, 1);
        return li;
    }

    void solve(List<List<Integer>> li, List<Integer> res, int k, int n , int idx) {
        if (k == res.size() && 0 == n) {
            li.add(new ArrayList<>(res));
            return;
        }
        if (n <= 0 || n < 0)
            return;

        for (int i = idx; i <= 9; i++) {
            res.add(i);
            solve(li, res, k, n-i , i+1);
            if (res.size() > 0)
                res.remove(res.size() - 1);
        }
    }
}