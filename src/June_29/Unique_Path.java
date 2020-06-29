/*
Unique Paths
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
Above is a 7 x 3 grid. How many possible unique paths are there?

Example 1:

Input: m = 3, n = 2
Output: 3
Explanation:
From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Right -> Down
2. Right -> Down -> Right
3. Down -> Right -> Right

Example 2:

Input: m = 7, n = 3
Output: 28

Constraints:

1 <= m, n <= 100
It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9.

 */


package June_29;

public class Unique_Path {

    public static int count = 0;

    public static int uniquePaths(int m, int n) {

        // Method 1
//        path(1, 1, n, m);
//        return count;


        // Method 2

        int [][] path = new int[m][n];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i > 0 && j > 0){
                    path[i][j] = path[i-1][j] + path[i][j-1];
                }else{
                    path[i][j] = 1;
                }
            }
        }

        return path[m-1][n-1];
    }

    public static void path(int i, int j, int n, int m){

        if(i == n && j == m){
            count++;
            return;
        }else if(i != n && j != m){
            path(i + 1, j, n, m);
            path(i , j + 1, n, m);
        }else if(i == n){
            path(i, j + 1, n, m);
        }else if(j == m){
            path(i + 1, j, n, m);
        }
    }

    public static void main(String[] args){
        System.out.println(uniquePaths(25,1));
    }
}
