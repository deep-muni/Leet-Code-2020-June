/*
Perfect Squares
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

Example 1:

Input: n = 12
Output: 3
Explanation: 12 = 4 + 4 + 4.
Example 2:

Input: n = 13
Output: 2
Explanation: 13 = 4 + 9.

 */

package June_27;

public class Perfect_Squares {

    public static int numSquares(int n) {

        int[] result = new int[n + 1];

        int root, minimum;

        for (int i = 1; i <= n; i++) {
            root = (int) Math.sqrt(i);
            minimum = result[i - 1];
            for (int j = root; j > 0; j--) {
                minimum = Math.min(result[i - j * j], minimum);
            }
            result[i] = minimum + 1;
        }
        return result[n];
    }

    public static void main(String[] args){
        System.out.println(numSquares(16));
    }
}
