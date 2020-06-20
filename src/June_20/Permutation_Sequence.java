/*
Permutation Sequence
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.

Example 1:

Input: n = 3, k = 3
Output: "213"

Example 2:

Input: n = 4, k = 9
Output: "2314"
 */

package June_20;

import java.util.ArrayList;

public class Permutation_Sequence {

    public static String getPermutation(int n, int k){

        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < n; i++){
            list.add(Integer.toString(i + 1));
        }

        ArrayList<String> result = new ArrayList<>();
        k = k - 1;
        double factorial = factorial(list.size());

        for(int i = 0; i < n; i++){
            factorial = Math.ceil(factorial / list.size());
            String temp = list.get((int) (k / factorial));
            list.remove((int) (k / factorial));
            result.add(temp);
            k = (int) (k % factorial);
        }

        StringBuilder sb = new StringBuilder();

        for (String s : result) {
            sb.append(s);
        }

        return sb.toString();
    }

    private static int factorial(int length) {
        int result = 1;
        for(int i = 2; i <= length; i++){
            result = result * i;
        }
        return result;
    }

    public static void main(String[] args){

        int n = 4;
        int k = 14;

        System.out.println(getPermutation(n, k));

    }

}
