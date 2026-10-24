package neetcode250._01_arrays_hashing;

import java.util.HashMap;
import java.util.HashSet;

public class _0036_ValidSudoku {
    // TODO - Given a 9x9 matrix of numeric characters, we need to determine whether the sudoku board is valid
    // The conditions for validity -
    // Each row must contain the digits 1-9 without repetition.
    // Each column must contain the digits 1-9 without repetition.
    // Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

    // ? Approach - Lets write individual loops for rows, columns and matrices.
    // ? Store the values & positions in a hashset, if we encounter a repeated values we simply throw a false boolean

    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> seenAtPos = new HashSet<String>();
        // We traverse each row, since this is a 2d matrix, the way we can access individual elements is through iterating over them
        for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
            for (char element : board[rowIdx]) {
                if (element != '.') {
                    String pos = element + " is present in row " + rowIdx;
                    if (seenAtPos.contains(pos)) {
                        return false;
                    } else {
                        seenAtPos.add(pos);
                    }
                }
            }
        }

        // For each column we need to iterate over a singular columns records
        for (int colIdx = 0; colIdx < 9; colIdx++) {
            for (int rowIdx = 0; rowIdx < 9; rowIdx++) {
                char element = board[rowIdx][colIdx];
                if (element != '.') {
                    String pos = element + " is present at column " + colIdx;
                    if (seenAtPos.contains(pos)) {
                        return false;
                    } else {
                        seenAtPos.add(pos);
                    }
                }

            }
        }

        // Now lets go for a 3x3 matrix, how do I find the matrix of an element, we simply divide the row and col idx by 3 since that's the matrix size
        for (int colIdx = 0; colIdx < 9; colIdx += 3){
            for (int rowIdx = 0; rowIdx < 9; rowIdx += 3){
                char element = board[rowIdx][colIdx];
                String pos = element + " is present at matrix " + rowIdx/3 + colIdx/3;
                if (element != '.') {
                    if (seenAtPos.contains(pos)){
                        return false;
                    }
                    else {
                        seenAtPos.add(pos);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
