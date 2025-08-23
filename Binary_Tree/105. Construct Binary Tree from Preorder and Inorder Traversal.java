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
     public TreeNode helper(int[] inorder, int[] preorder, int prelo, int prehi, int inlo, int hi ){
        if(prelo>prehi) return null;
        TreeNode root= new TreeNode();
        
            root.val=preorder[prelo];

        int i=inlo;
        while(inorder[i]!=preorder[prelo]) i++;
        int leftsize=i-inlo;
        root.left=helper( inorder,  preorder, prelo+1,  prelo+leftsize,  inlo,  i-1 );
        root.right=helper( inorder,  preorder, prelo+leftsize+1,  prehi,  i+1,  hi );
        return root;

    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n= preorder.length;
         return helper(inorder, preorder, 0,n-1,  0, n-1 );
    
    }
}
