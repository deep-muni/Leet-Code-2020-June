/*
Longest Duplicate Substring
Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.
(The occurrences may overlap.)

Return any duplicated substring that has the longest possible length.
(If S does not have a duplicated substring, the answer is "".)

Example 1:

Input: "banana"
Output: "ana"

Example 2:

Input: "abcd"
Output: ""

Hide Hint #1
Binary search for the length of the answer. (If there's an answer of length 10, then there are answers of length 9, 8, 7, ...)

Hide Hint #2
To check whether an answer of length K exists, we can use Rabin-Karp 's algorithm.
*/

package June_19;

import java.util.*;

public class Longest_Substring {

    public static String longestDupSubstring(String S) {

        HashMap<String , Integer> subsMap = new HashMap<>();
        int index;

        for (int i = 0; i < S.length(); i++) {
            for (int j = i + 1; j <= S.length(); j++) {
                if(subsMap.get(S.substring(i, j)) == null){
                    index = 1;
                }else{
                    index = subsMap.get(S.substring(i, j)) + 1;
                }

                if(S.substring(i, j).length() > 1){
                    subsMap.put(S.substring(i, j), index);
                }
            }
        }

        String str = "";
        int max = 0;

        for (Map.Entry<String, Integer> stringIntegerEntry : subsMap.entrySet()) {
            if ((int) ((Map.Entry) stringIntegerEntry).getValue() > 1) {
                String temp = (String) ((Map.Entry) stringIntegerEntry).getKey();
                if (temp.length() > max) {
                    max = temp.length();
                    str = temp;
                }
            }
        }

        return str;
    }

    public static void main(String[] args){

        String S = "banananan";

        System.out.println("The longest duplicate substring is: " + longestDupSubstring(S));

    }
}
