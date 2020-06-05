/*
Random Pick with Weight
Given an array w of positive integers, where w[i] describes the weight of index i,
write a function pickIndex which randomly picks an index in proportion to its weight.

Example 1:
Input:
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]

Example 2:
Input:
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments.
Solution's constructor has one argument, the array w. pickIndex has no arguments.
Arguments are always wrapped with a list, even if there aren't any.
 */


package June_5;

public class mainClass {

    public static void main(String[] args){
        int[] w = {1, 14, 7 ,10};

        Random_Pick_Weight obj = new Random_Pick_Weight(w);
        System.out.println("\nIndex: " + obj.pickIndex());
    }

}
