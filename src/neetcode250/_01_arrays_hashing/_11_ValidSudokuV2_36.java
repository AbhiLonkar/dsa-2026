package neetcode250._01_arrays_hashing;

import java.lang.reflect.GenericDeclaration;
import java.util.HashSet;

public class _11_ValidSudokuV2_36 {
    public static boolean isValidSudoku(char[][] sudoku) {
        // three conditions - a value shouldn't be repeated in a row
        // a value shouldn't repeat in a column
        // a value shouldn't repeat in a matrix
        // hashset could be a good option as we can check for presence

        HashSet<String> encountered = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char ch = sudoku[row][col];
                if (ch != '.') {
                    String presentAt = ch + " is present in row: " + row;
                    if (encountered.contains(presentAt)) {
                        return false;
                    }
                    encountered.add(presentAt);
                }
            }
        }
        for (int col = 0; col < 9; col++) {
            for (int row = 0; row < 9; row++) {
                char ch = sudoku[row][col];
                if (ch != '.') {
                    String presentAt = ch + " is present in col: " + col;
                    if (encountered.contains(presentAt)) {
                        return false;
                    }
                    encountered.add(presentAt);
                }
            }
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char ch = sudoku[row][col];
                if (ch != '.') {
                    String presentAt = ch + " is present in matrix " + row / 3 + " " + col / 3;
                    if (encountered.contains(presentAt)) {
                        return false;
                    }
                    encountered.add(presentAt);
                }
            }
        }
        return true;
    }

    public static boolean isValidSudokuOpt(char[][] sudoku) {
        HashSet<String> rowPresence = new HashSet<>();
        HashSet<String> colPresence = new HashSet<>();
        HashSet<String> matrixPresence = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char ch = sudoku[row][col];
                if (ch != '.') {
                    String rowPresencePos = ch + " is present at: " + row;
                    String colPresencePos = ch + " is present at: " + col;
                    String matrixPresencePos = ch + " is present at: " + row / 3 + " " + col / 3;
                    if (rowPresence.contains(rowPresencePos)) {
                        return false;
                    } else {
                        rowPresence.add(rowPresencePos);
                    }
                    if (colPresence.contains(colPresencePos)) {
                        return false;
                    } else {
                        colPresence.add(colPresencePos);
                    }
                    if (matrixPresence.contains(matrixPresencePos)) {
                        return false;
                    } else {
                        matrixPresence.add(matrixPresencePos);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'1', '2', '.', '.', '3', '.', '.', '.', '.'},
                {'4', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '.', '3'},
                {'5', '.', '.', '.', '6', '.', '.', '.', '4'},
                {'.', '.', '.', '8', '.', '3', '.', '.', '5'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '2', '.', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '8'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(board));
    }
}
