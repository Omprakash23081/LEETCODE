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
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode Node) {
        if (Node == null) {
            return 0;
        }
        int Lmax = helper(Node.left);
        int Rmax = helper(Node.right);
        max = Math.max(max, Lmax + Rmax);
        return 1 + Math.max(Lmax, Rmax);
    }
}