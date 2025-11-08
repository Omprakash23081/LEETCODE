/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // Map<Integer
    private int[]  solve(TreeNode root){
        if(root==null) return new int[2];

        int left[] = solve(root.left);
        int right[] = solve(root.right);

        int res[] = new int[2];

        res[0] = root.val + left[1] + right[1];
        res[1] = Math.max(left[0] , left[1]) + Math.max(right[0] , right[1]);

        return res; 
    }

    public int rob(TreeNode root) {
        int res[] = solve(root);
        return Math.max(res[0] , res[1]);
    }
}