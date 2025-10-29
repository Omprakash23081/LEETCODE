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
    public int maxDepth(TreeNode root) {
        return helper(root);
    }

    private int helper(TreeNode Node) {
        if (Node == null) {
            return 0;
        }
        int Lmax = helper(Node.left);
        int Rmax = helper(Node.right);
        return 1 + Math.max(Rmax, Lmax);
    }
}