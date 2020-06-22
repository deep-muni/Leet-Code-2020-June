/*
Single Number II

Solution
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99

 */

package June_22;

import java.util.Arrays;

public class Single_Number {

    public static int singleNumber(int[] nums) {

        Arrays.sort(nums);

        System.out.println(Arrays.toString(nums));
        int i = 0;

        for(i = 0; i < nums.length - 1; i = i + 3){
            if(nums[i] == nums[i+1]){
                continue;
            }
            break;
        }

        return nums[i];
    }

    public static void main(String[] arg){
        int[] nums = {2, 2, 3, 2};

        System.out.println(singleNumber(nums));
    }
}
