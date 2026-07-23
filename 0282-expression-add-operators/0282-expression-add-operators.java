class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> li = new ArrayList<>();
        solve(li, num, 0, target, "", 0, 0);
        return li;
    }

    void solve(List<String> li, String s, int idx, int target, String res, long curr, long priv) {
        if (idx == s.length()) {
            if (curr == target)
                li.add(new String(res));
            return;
        }

        for (int i = idx; i < s.length(); i++) {
            if (i > idx && s.charAt(idx) == '0')
                return;
            String sv = s.substring(idx, i + 1);
            long v = Long.parseLong(sv);

            if (idx == 0) {
                solve(li, s, i + 1, target, sv, v, v);
            } else {
                solve(li, s, i + 1, target, res + "+" + sv, curr + v, v);
                solve(li, s, i + 1, target, res + "-" + sv, curr - v, -v);
                solve(li, s, i + 1, target, res + "*" + sv, (curr - priv) + (priv * v), priv*v);
            }
        }
    }
}