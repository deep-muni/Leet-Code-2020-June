/*
Unique Binary Search Trees
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */

package June_24;

public class Unique_BST {

    public static int numTrees(int n) {

        int[] counter = new int[n + 1];

        counter[0] = 1;
        counter[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                counter[i] = counter[i] + (counter[i - j] * counter[j - 1]);
            }
        }

        return counter[n];

    }

    public static void main(String[] args){
        System.out.println(numTrees(7));
    }
}
