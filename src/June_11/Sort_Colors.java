/*

Sort Colors

Solution
Given an array with n objects colored red, white or blue, 
sort them in-place so that objects of the same color are adjacent, 
with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

*/

package June_11;

import java.util.Arrays;

public class Sort_Colors{

	public static void sortColors(int[] nums) {
        
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length - 1; j++){
                if(nums[j] > nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    	
    	System.out.println(Arrays.toString(nums));
    }


	public static void main(String[] args){
		int[] nums = {2, 0, 2, 1, 1, 0};

		System.out.println("Before");
		System.out.println(Arrays.toString(nums));
		System.out.println("\nAfter");
		sortColors(nums);

	}

}
