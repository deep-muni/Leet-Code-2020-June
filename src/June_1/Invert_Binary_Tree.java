/*

Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

*/

package June_1;

public class Invert_Binary_Tree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public static void invert(TreeNode current){

        if(current != null){
            TreeNode temp;

            temp = current.left;
            current.left = current.right;
            current.right = temp;
        }else{
            return;
        }

        invert(current.left);
        invert(current.right);
    }

    public static void printTree(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args){

        TreeNode node_1 = new TreeNode(1, null, null);
        TreeNode node_3 = new TreeNode(3, null, null);
        TreeNode node_6 = new TreeNode(6, null, null);
        TreeNode node_9 = new TreeNode(9, null, null);

        TreeNode node_2 = new TreeNode(2, node_1, node_3);
        TreeNode node_7 = new TreeNode(7, node_6, node_9);

        TreeNode root = new TreeNode(4, node_2, node_7);

        System.out.println("Before");
        printTree(root);
        System.out.println("\n\nAfter");
        printTree(invertTree(root));

    }
}
