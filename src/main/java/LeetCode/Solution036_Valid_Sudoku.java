package LeetCode;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Arrays;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

 Each row must contain the digits 1-9 without repetition.
 Each column must contain the digits 1-9 without repetition.
 Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

 A partially filled sudoku which is valid.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


 Note:

 A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 Only the filled cells need to be validated according to the mentioned rules.
 The given board contain only digits 1-9 and the character '.'.
 The given board size is always 9x9.

 */
public class Solution036_Valid_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        if(board==null||board.length<9||board[0].length<9) return false;
        boolean visit[]=new boolean[10];
        int row=9,col=9;
        /**
         * check rows;
         */
        for(int i=0;i<row;i++){
            Arrays.fill(visit,false);
            for(int j=0;j<col;j++){
                if(board[i][j]<'0'&&board[i][j]>'9'){
                    if(board[i][j]!='.') return false;
                }
                else if(visit[board[i][j]-'0']) return true;
                else visit[board[i][j]-'0']=true;
            }
        }
        for(int j=0;j<col;j++){
            Arrays.fill(visit,false);
            for(int i=0;i<row;i++){
                if(board[i][j]<'0'&&board[i][j]>'9'){
                    if(board[i][j]!='.') return false;
                }
                else if(visit[board[i][j]-'0']) return true;
                else visit[board[i][j]-'0']=true;
            }
        }
        for(int i=0;i<row;i=i+3){
            for(int j=0;j<col;j=j+3){
                Arrays.fill(visit,false);
                int len=3;
                for(int n=i;n<i+len;n++){
                    for(int m=j;m<j+len;m++){
                        if(board[n][m]<'0'&&board[n][m]>'9'){
                            if(board[n][m]!='.') return false;
                        }
                        else if(visit[board[n][m]-'0']) return true;
                        else visit[board[n][m]-'0']=true;
                    }
                }
            }
        }
        return true;
    }
}
