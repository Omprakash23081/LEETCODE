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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> li = new ArrayList<>();
        bfs(li , root , 0);
        return li;
    } 

    private void bfs(List<List<Integer>> li , TreeNode root , int idx){
        if(root==null)return;

        if(li.size()>idx)
            li.get(idx).add(root.val);
        else{
            li.add(new ArrayList());  
            li.get(idx).add(root.val);
        }
            
        
        bfs(li , root.left , idx+1);
        bfs(li , root.right , idx+1);
    }
} 