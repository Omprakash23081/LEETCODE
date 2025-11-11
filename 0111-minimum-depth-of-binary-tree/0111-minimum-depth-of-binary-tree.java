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
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        return solve(root);
    }

    private int solve(TreeNode root){
        if(root==null) return Integer.MAX_VALUE;
        if(root.left==null && root.right==null) return 1;

        int x = solve(root.left);
        int y = solve(root.right);
        
        return Math.min(x , y)+1;
    }
} 