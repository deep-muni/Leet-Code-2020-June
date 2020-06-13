/*
Given a set of distinct positive integers,
find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)

Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
*/

package June_13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Largest_Divisible_Subset {

    public static List<Integer> largestDivisibleSubset1(int[] nums) {

        List<Integer> subset = new ArrayList<>();

        if(nums.length == 0){
            return subset;
        }

        Arrays.sort(nums);
        int[] counter = new int[nums.length];
        Arrays.fill(counter, 0);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j >= 0; j--) {
                if (nums[i] % nums[j] == 0) {
                    counter[i] = Math.max(counter[i], counter[j] + 1);
                }
            }
        }

        int max = 0;
        for(int i = 0; i < counter.length; i++){
            if(counter[max] < counter[i]){
                max = i;
            }
        }

        int temp = nums[max];
        int count = counter[max];

        for(int i = max; i >= 0; i--){
            if(temp % nums[i] == 0 && counter[i] == count){
                subset.add(nums[i]);
                temp = nums[i];
                count--;
            }
        }

        Collections.sort(subset);
        return subset;
    }

    public static void main(String[] args){
        int[] nums = {4, 8, 10, 240};

        System.out.println(largestDivisibleSubset1(nums));
    }
}
