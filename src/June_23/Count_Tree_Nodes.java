/*

Count Complete Tree Nodes

Solution
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last,
is completely filled, and all nodes in the last level are as far left as possible.
It can have between 1 and 2h nodes inclusive at the last level h.

Example:

Input:
    1
   / \
  2   3
 / \  /
4  5 6

Output: 6

 */

package June_23;

public class Count_Tree_Nodes {

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

    public static int counter = -1;

    public static void count(TreeNode root){
        if(root == null){
            counter++;
            return;
        }
        count(root.left);
        count(root.right);
    }

    public static int countNodes(TreeNode root) {
        count(root);
        return counter;
    }

    public static void main(String[] args){

        TreeNode node_4 = new TreeNode(4, null, null);
        TreeNode node_5 = new TreeNode(5, null, null);
        TreeNode node_6 = new TreeNode(6, null, null);

        TreeNode node_2 = new TreeNode(2, node_4, node_5);
        TreeNode node_3 = new TreeNode(3, node_6, null);

        TreeNode root = new TreeNode(1, node_2, node_3);

        System.out.println(countNodes(root));

    }

}
