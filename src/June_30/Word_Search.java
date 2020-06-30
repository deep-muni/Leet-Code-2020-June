/*

Word Search II
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or
vertically neighboring. The same letter cell may not be used more than once in a word.
Example:

Input:
board = [
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
words = ["oath","pea","eat","rain"]
Output: ["eat","oath"]
Note:

All inputs are consist of lowercase letters a-z.
The values of words are distinct.

Hide Hint #1
You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

Hide Hint #2
If the current candidate does not exist in all words' prefix, you could stop backtracking immediately.
What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not?
How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem:
Implement Trie (Prefix Tree) first.

 */

package June_30;

import java.util.ArrayList;
import java.util.List;

public class Word_Search {

    public static boolean[][] visited;

    public static List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;

        List<String> resultList = new ArrayList<>();

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++) {
                for (String word : words) {
                    visited = new boolean[rows][cols];
                    if (word.charAt(0) == board[i][j] && wordSearch(i, j, 0, word, board)) {
                        if (!resultList.contains(word)) {
                            resultList.add(word);
                        }
                    }
                }
            }
        }
        return resultList;
    }

    public static boolean wordSearch(int i, int j, int index, String word, char[][] board){
        if(index == word.length()) {
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || word.charAt(index) != board[i][j] || visited[i][j]) {
            return false;
        }

        visited[i][j] = true;
        if(wordSearch(i + 1, j, index + 1, word, board) || wordSearch(i - 1, j, index + 1, word, board) ||
                wordSearch(i, j + 1, index + 1, word, board) || wordSearch(i, j - 1, index + 1, word, board)){
            return true;
        }
        visited[i][j] = false;

        return false;
    }

    public static void main(String[] args){
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(findWords(board, words));
    }
}
