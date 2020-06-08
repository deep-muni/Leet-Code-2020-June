/*
Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true
Explanation: 2^0 = 1

Example 2:

Input: 16
Output: true
Explanation: 2^4 = 16

Example 3:
Input: 218
Output: false
*/

package June_8;

public class Power_of_Two {

    public static boolean isPowerOfTwo(int n) {

        long m = -1;
        int i = 0;

        while(m < n){
            m = (long) Math.pow(2, i);
            if(m == n){
                return true;
            }
            i++;
        }

        return false;

        /* Single line code */
        //  return (n & (n - 1)) == 0;
    }

    public static void main(String[] args){

        int n = 2147483647;

        if(isPowerOfTwo(n)){
            System.out.println("Number " + n + " is a power of 2");
        }else{
            System.out.println("Number " + n + " is not a power of 2");
        }

    }

}
