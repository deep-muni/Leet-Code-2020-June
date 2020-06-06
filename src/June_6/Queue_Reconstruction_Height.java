/*
Queue Reconstruction by Height
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k),
where h is the height of the person and
k is the number of people in front of this person who have a height greater than or equal to h.
Write an algorithm to reconstruct the queue.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

Hide Hint #1
What can you say about the position of the shortest person?
If the position of the shortest person is i, how many people would be in front of the shortest person?

Hide Hint #2
Once you fix the position of the shortest person, what can you say about the position of the second shortest person?
*/
package June_6;

import java.util.Arrays;

public class Queue_Reconstruction_Height {

    public static int[][] reconstructQueue(int[][] people) {

        int[][] result = new int[people.length][2];

        for(int i = 0; i < people.length; i++){
            for(int j = 0; j < (people.length-i-1); j++){
                if(people[j][0] < people[j+1][0]){
                    int[] temp = people[j];
                    people[j] = people[j+1];
                    people[j+1] = temp;
                }
                if(people[j][0] == people[j+1][0]){
                    if(people[j][1] > people[j+1][1]){
                        int[] temp = people[j];
                        people[j] = people[j+1];
                        people[j+1] = temp;
                    }
                }
            }
        }

        for(int i = 0; i < people.length; i++){
            if (result[people[i][1]][0] != 0) {
                for (int j = people.length - 1; j > people[i][1]; j--) {
                    result[j] = result[j - 1];
                }
            }
            result[people[i][1]] = people[i];
        }
        return result;
    }

    public static void main(String[] args){

        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        reconstructQueue(people);

        System.out.println("Before");
        System.out.println(Arrays.deepToString(people));

        System.out.println("\nAfter");
        System.out.println(Arrays.deepToString(reconstructQueue(people)));

    }

}
