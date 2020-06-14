/*
Cheapest Flights Within K Stops
There are n cities connected by m flights. Each flight starts from city u and arrives at v with a price w.

Now given all the cities and flights, together with starting city src and the destination dst,
your task is to find the cheapest price from src to dst with up to k stops. If there is no such route, output -1.

Example 1:
Input:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 1
Output: 200
Explanation:
The cheapest price from city 0 to city 2 with at most 1 stop costs 200, as marked red in the picture.

Example 2:
Input:
n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
src = 0, dst = 2, k = 0
Output: 500

Explanation:

The cheapest price from city 0 to city 2 with at most 0 stop costs 500, as marked blue in the picture.

 */


package June_14;

import java.util.Arrays;

public class Cheap_Flight {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        int MAX = 100000000;

        int[][] matrix = new int[K + 2][n];
        for(int[] mat: matrix){
            Arrays.fill(mat, MAX);
        }

        matrix[0][src] = 0;

        for(int i = 1; i <= K + 1; i++){
            for(int[] flight: flights){
                int pA = flight[0];
                int pB = flight[1];
                int cost = flight[2];

                matrix[i][pB] = Math.min(matrix[i][pB], Math.min(matrix[i - 1][pB], (matrix[i - 1][pA] + cost)));
            }
        }

        if(matrix[K + 1][dst] != MAX){
            return matrix[K + 1][dst];
        }else{
            return  -1;
        }
    }

    public static void main(String[] args){

        int n = 3;
        int[][] flights = {{ 0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dest = 2;
        int K = 1;

        System.out.println(findCheapestPrice(n, flights, src, dest, K));

    }

}
