package example1;

import java.util.Arrays;

/**
 * @author Andrey Ledovskikh
 */
public class Solution36 {

    public static void main(String[] args) {
        //[["5","3",".",".","7",".",".",".","."]
        //,["6",".",".","1","9","5",".",".","."]
        //,[".","9","8",".",".",".",".","6","."]
        //,["8",".",".",".","6",".",".",".","3"]
        //,["4",".",".","8",".","3",".",".","1"]
        //,["7",".",".",".","2",".",".",".","6"]
        //,[".","6",".",".",".",".","2","8","."]
        //,[".",".",".","4","1","9",".",".","5"]
        //,[".",".",".",".","8",".",".","7","9"]]
        var board = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(new Solution36().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        //checkSquares
        for (var x = 0; x < 3; x++) {
            for (var y = 0; y < 3; y++) {
                if (!checkCorrectSquare(board, x * 3, y * 3)) {
                    return false;
                }
            }
        }

        //checkRows
        for (var xLine : board) {
            var memo = new int[10];
            for (char c : xLine) {
                if (c != '.') {
                    memo[c - 49]++;
                }
            }

            if (Arrays.stream(memo).filter(value -> value > 1).count() > 0) {
                return false;
            }
        }

        //checkColumns
        for (var y = 0; y < board.length; y++) {
            var memo = new int[10];
            for (char[] chars : board) {
                if (chars[y] != '.') {
                    memo[chars[y] - 49]++;
                }
            }

            if (Arrays.stream(memo).filter(value -> value > 1).count() > 0) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCorrectSquare(char[][] board, int startX, int startY) {
        var memo = new int[10];
        for (var x = startX; x < startX + 3; x++) {
            for (var y = startY; y < startY + 3; y++) {
                if (board[x][y] != '.') {
                    memo[board[x][y] - 49]++;
                }
            }
        }

        return Arrays.stream(memo).filter(value -> value > 1).count() <= 0;
    }
}
