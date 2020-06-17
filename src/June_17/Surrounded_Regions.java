/*
Surrounded Regions
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X

After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X

Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'.
Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'.
Two cells are connected if they are adjacent cells connected horizontally or vertically.

*/


package June_17;

import java.util.Arrays;

public class Surrounded_Regions {

    public static void printMatrix(char[][] board){
        for(char[] b: board){
            System.out.println(Arrays.toString(b));
        }
    }

    // DCTB = Direct connection to border
    public static void solve_DCTB(char[][] board) {

        int row = board.length;

        for(int i = 1; i < row - 1; i++){
            int col = board[i].length;
            for(int j = 1; j < col - 1; j++){

                if(i == 1 && j == 1){
                    if(board[i - 1][j] != 'O' && board[i][j - 1] != 'O') {
                        board[i][j] = 'X';
                    }
                }else if(i == 1 && j == col - 2){
                    if(board[i - 1][j] != 'O' && board[i][j + 1] != 'O') {
                        board[i][j] = 'X';
                    }
                }else if(i == row - 2 && j == 1){
                    if(board[i][j - 1] != 'O' && board[i + 1][j] != 'O') {
                        board[i][j] = 'X';
                    }
                }else if(i == row - 2 && j == col - 2){
                    if(board[i + 1][j] != 'O' && board[i][j + 1] != 'O') {
                        board[i][j] = 'X';
                    }
                }else if(i == 1){
                    if(board[i - 1][j] != 'O'){
                        board[i][j] = 'X';
                    }
                }else if(j == 1){
                    if(board[i][j - 1] != 'O'){
                        board[i][j] = 'X';
                    }
                }else if(i == row - 2){
                    if(board[i + 1][j] != 'O'){
                        board[i][j] = 'X';
                    }
                }else if(j == col - 2){
                    if(board[i][j + 1] != 'O'){
                        board[i][j] = 'X';
                    }
                }else{
                    board[i][j] = 'X';
                }
            }
        }

        System.out.println("\nAfter Direct Connection\n");
        printMatrix(board);
    }

    // IDCTB = Indirect Direct connection to border
    public static void solve_IDCTB(char[][] board) {

        if(board == null || board.length == 0){
            return;
        }

        int x_co_ordinate = board.length;
        int y_co_ordinate = board[0].length;

        for(int i = 0; i < x_co_ordinate; i++){
            if(board[i][0] == 'O') {
                temp_change(board, i, 0);
            }
            if(board[i][y_co_ordinate - 1] == 'O'){
                temp_change(board, i, y_co_ordinate - 1);
            }
        }

        for(int j = 0; j < y_co_ordinate; j++){
            if(board[0][j] == 'O'){
                temp_change(board, 0, j);
            }
            if(board[x_co_ordinate - 1][j] == 'O'){
                temp_change(board, x_co_ordinate - 1, j);
            }
        }

        for(int i = 0; i < x_co_ordinate; i++){
            for(int j = 0; j < y_co_ordinate; j++){
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if(board[i][j] == 'o') {
                    board[i][j] = 'O';
                }
            }
        }

        System.out.println("\nAfter Indirect connection\n");
        printMatrix(board);
    }

    public static void temp_change(char[][] board, int i, int j){

        int x_co_ordinate = board.length;
        int y_co_ordinate = board[0].length;

        if(i < 0 || i >= x_co_ordinate || j < 0 || j >= y_co_ordinate || board[i][j] != 'O'){
            return;
        }

        board[i][j] = 'o';
        temp_change(board, i - 1, j);
        temp_change(board, i, j - 1);
        temp_change(board, i, j + 1);
        temp_change(board, i + 1, j);
    }

    public static void main(String[] args){

        char[][] board = {{'O','X','X','O','X'},{'X','O','O','X','O'},{'X','O','X','O','X'},{'O','X','O','O','O'},{'X','X','O','X','O'}};

        System.out.println("Before\n");
        printMatrix(board);

        solve_DCTB(board);
        solve_IDCTB(board);
    }

}
