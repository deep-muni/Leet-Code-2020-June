/*
Sum Root to Leaf Numbers
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

Note: A leaf is a node with no children.

Example:

Input: [1,2,3]
    1
   / \
  2   3
Output: 25
Explanation:
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.
Therefore, sum = 12 + 13 = 25.
Example 2:

Input: [4,9,0,5,1]
    4
   / \
  9   0
 / \
5   1
Output: 1026
Explanation:
The root-to-leaf path 4->9->5 represents the number 495.
The root-to-leaf path 4->9->1 represents the number 491.
The root-to-leaf path 4->0 represents the number 40.
Therefore, sum = 495 + 491 + 40 = 1026.
 */

package June_26;

import java.util.ArrayList;

public class Root_to_Leaf {

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

    public static ArrayList<Integer> finalSum = new ArrayList<>();

    public static void findSum(TreeNode root, int[] route, int routeLength){
        if(root == null){
            return;
        }

        route[routeLength] = root.val;
        routeLength++;

        if (root.left == null && root.right == null) {
            String temp = "";
            for (int i = 0; i < routeLength; i++) {
                temp += route[i];
            }
            finalSum.add(Integer.parseInt(temp));
        } else{
            findSum(root.left, route, routeLength);
            findSum(root.right, route, routeLength);
        }
    }

    public static int sumNumbers(TreeNode root) {
        int[] route = new int[1000];
        findSum(root, route, 0);
        int sum = 0;
        for(int temp: finalSum){
            sum += temp;
        }
        return sum;
    }

    public static void main(String[] args){

        TreeNode node_4 = new TreeNode(5, null, null);
        TreeNode node_5 = new TreeNode(1, null, null);
        TreeNode node_6 = new TreeNode(6, null, null);

        TreeNode node_2 = new TreeNode(9, node_4, node_5);
        TreeNode node_3 = new TreeNode(0, null, null);

        TreeNode root = new TreeNode(4, node_2, node_3);

        System.out.println(sumNumbers(root));

    }
}
