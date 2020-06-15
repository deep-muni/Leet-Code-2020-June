/*

Search in a Binary Search Tree
Given the root node of a binary search tree (BST) and a value.
You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node.
If such node doesn't exist, you should return NULL.

For example,

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2
You should return this subtree:

      2
     / \
    1   3
In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.

Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.

*/

package June_15;

public class Search_BST {

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

    public static TreeNode searchBST(TreeNode root, int val){

        if (root == null || root.val == val)
            return root;

        if (root.val > val)
            return searchBST(root.left, val);

        return searchBST(root.right, val);
    }

    public static void main(String[] args){

        TreeNode node_1 = new TreeNode(1, null, null);
        TreeNode node_3 = new TreeNode(3, null, null);

        TreeNode node_2 = new TreeNode(2, node_1, node_3);
        TreeNode node_7 = new TreeNode(7, null, null);

        TreeNode root = new TreeNode(4, node_2, node_7);

        int val = 2;

        System.out.println(node_2);

        System.out.println(searchBST(root, val));
    }
}

