package com.Q36_Valid_Sudoku;

//2ms ver
/*
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][][] blockCnt = new boolean[3][3][9];
        boolean[][] rowCnt = new boolean[9][9];
        boolean[][] colCnt = new boolean[9][9];
        int idx;
        int blockIdxI;
        int blockIdxJ;

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] != '.') {
                    idx = (int)(board[row][col] - '1');
                    blockIdxI = row/3;
                    blockIdxJ = col/3;

                    if(rowCnt[row][idx] || colCnt[col][idx] || blockCnt[blockIdxI][blockIdxJ][idx]){
                        return false;
                    }
                    else{
                        rowCnt[row][idx] = true;
                        colCnt[col][idx] = true;
                        blockCnt[blockIdxI][blockIdxJ][idx] = true;
                    }
                }
            }
        }
        return true;
    }
}
*/

//1ms ver
class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!isValid(board, i, j, board[i][j]))
                        return false;
                }
            }
        }
        return true;
    }

    public boolean isValid(char[][] board, int row, int col, char num) {

        //for row checking
        for (int i = col + 1; i < 9; i++) {
            if (board[row][i] == num)
                return false;
        }

        //For col checking
        for (int i = row + 1; i < 9; i++) {
            if (board[i][col] == num)
                return false;
        }

        //for internal square
        int x = row - row % 3, y = col - col % 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (board[i][j] == num && !(i == row && j == col))
                    return false;
            }
        }
        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        char[][][] inputs = {
                {
                        {'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                },
                {
                        {'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
                },
                {
                        {'.', '.', '4', '.', '.', '.', '6', '3', '.'}
                        , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                        , {'5', '.', '.', '.', '.', '.', '.', '9', '.'}
                        , {'.', '.', '.', '5', '6', '.', '.', '.', '.'}
                        , {'4', '.', '3', '.', '.', '.', '.', '.', '1'}
                        , {'.', '.', '.', '7', '.', '.', '.', '.', '.'}
                        , {'.', '.', '.', '5', '.', '.', '.', '.', '.'}
                        , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                        , {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
                }
        };

        Solution solution = new Solution();
        for (char[][] input : inputs) {
            System.out.println(solution.isValidSudoku(input));
            System.out.println("==============");
        }
    }
}
