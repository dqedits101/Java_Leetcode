/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helper(root,sb);
        return sb.toString();
    }
    public void helper(TreeNode root, StringBuilder sb){
        if(root == null){
            if(sb.length()==0)
            sb.append("null");
            else{
                sb.append(",null");
            }
            return;
        }

        if(sb.length()!=0){
            sb.append(",");
        }
        sb.append(root.val);
        helper(root.left, sb);
        helper(root.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        return dHelper(nodes);
    }
    int i = 0;
    public TreeNode dHelper(String[] nodes){
        if(i>= nodes.length || nodes[i].equals("null")){
            i++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes[i++]));
        node.left = dHelper(nodes);
        node.right = dHelper(nodes);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
