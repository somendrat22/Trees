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
    public void flatten(TreeNode root) {
        
        getItFlat(root);
    }
    public TreeNode getItFlat(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode lt = getItFlat(left);
        TreeNode rt = getItFlat(right);
        if(left == null && right == null){
            return root;
        }else if(left == null){
            return rt;
        }else if(right == null){
            root.left = null;
            root.right = left;
            return lt;
        }
        lt.right = right;
        root.left = null;
        root.right = left;
        return rt;
    }
}