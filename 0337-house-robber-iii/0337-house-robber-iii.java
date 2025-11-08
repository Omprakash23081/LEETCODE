class Solution {
    Map<TreeNode, int[]> dp = new HashMap<>();

    private int solve(TreeNode root, boolean canRob) {
        if (root == null) return 0;

        if (!dp.containsKey(root)) dp.put(root, new int[2]);
        int[] val = dp.get(root);

        if (canRob && val[1] != 0) return val[1];
        if (!canRob && val[0] != 0) return val[0];

        if (canRob) {
            int rob = root.val + solve(root.left, false) + solve(root.right, false);
            val[1] = rob;
            return rob;
        } else {
            int notRob = Math.max(solve(root.left, true), solve(root.left, false)) +
                         Math.max(solve(root.right, true), solve(root.right, false));
            val[0] = notRob;
            return notRob;
        }
    }

    public int rob(TreeNode root) {
        return Math.max(solve(root, true), solve(root, false));
    }
}
