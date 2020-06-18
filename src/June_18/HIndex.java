/*
H-Index II
Given an array of citations sorted in ascending order (each citation is a non-negative integer) of a researcher,
write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia:
"A scientist has index h if h of his/her N papers have at least h citations each,
and the other N − h papers have no more than h citations each."

Example:

Input: citations = [0,1,3,5,6]
Output: 3
Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had
             received 0, 1, 3, 5, 6 citations respectively.
             Since the researcher has 3 papers with at least 3 citations each and the remaining
             two with no more than 3 citations each, her h-index is 3.
Note:

If there are several possible values for h, the maximum one is taken as the h-index.

Follow up:

This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in ascending order.
Could you solve it in logarithmic time complexity?

Hide Hint #1
Expected runtime complexity is in O(log n) and the input is sorted.
 */

package June_18;

public class HIndex {

    // O(N)

    public static int hIndex(int[] citations) {

        if(citations.length == 0){
            return 0;
        }

        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= (citations.length - i)){
                return citations.length - i;
            }
        }

        return 0;
    }

    //O(Log N)

//    public static int hIndex(int[] citations) {
//
//        int low = 0, high = citations.length - 1, mid;
//
//        while (low <= high) {
//            mid = (low + high) / 2;
//
//            if (citations.length - mid > citations[mid])
//                low = mid + 1;
//            else
//                high = mid - 1;
//        }
//
//        System.out.println(high + " " + low);
//
//        return citations.length - low;
//    }

    public static void main(String[] args){
        int[] citations = {0, 1 , 3, 5, 6};

        System.out.println(hIndex(citations));
    }
}
