package LeetCode;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import static java.lang.System.out;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

 A sudoku solution must satisfy all of the following rules:

 Each of the digits 1-9 must occur exactly once in each row.
 Each of the digits 1-9 must occur exactly once in each column.
 Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
 Empty cells are indicated by the character '.'.

 Note:

 The given board contain only digits 1-9 and the character '.'.
 You may assume that the given Sudoku puzzle will have a single unique solution.
 The given board size is always 9x9.

 test input:
 [[".",".","9","7","4","8",".",".","."],["7",".",".",".",".",".",".",".","."],[".","2",".","1",".","9",".",".","."],[".",".","7",".",".",".","2","4","."],[".","6","4",".","1",".","5","9","."],[".","9","8",".",".",".","3",".","."],[".",".",".","8",".","3",".","2","."],[".",".",".",".",".",".",".",".","6"],[".",".",".","2","7","5","9",".","."]]
 */
public class Solution037_Sudoku_Solver {

    public boolean recur(int index,char[][] board,boolean[][] row,boolean[][] col,boolean[][]grid,int fill){
         if(fill==81) return true;
        while(index<81){
            if(board[index/9][index%9]=='.') break;
            index++;
        }
        int r=index/9;
        int c=index%9;
        int g=r/3*3+c/3;
        boolean[] maybe=new boolean[9];
        for(int i=0;i<9;i++){
            maybe[i]=row[r][i]||col[c][i]||grid[g][i];
        }
        for(int i=0;i<9;i++){
            if(maybe[i]==false){
                board[r][c]=(char)(i+1+'0');
                row[r][i]=true;
                col[c][i]=true;
                grid[g][i]=true;
                boolean flag=recur(index+1,board,row,col,grid,fill+1);
                if(flag) return true;
                board[r][c]='.';
                row[r][i]=false;
                col[c][i]=false;
                grid[g][i]=false;
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        boolean[][] row=new boolean[9][9];
        boolean[][] col=new boolean[9][9];
        boolean[][] grid=new boolean[9][9];
        for(int i=0;i<9;i++){
            row[i]=new boolean[9];
            col[i]=new boolean[9];
            grid[i]=new boolean[9];
        }
        int fill=0;
        for(int i=0;i<9;i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    fill++;
                    row[i][ch - '0' - 1] = true;
                    col[j][ch - '0' - 1] = true;
                    grid[i / 3 * 3 + j / 3][ch - '0' - 1] = true;
                }
            }
        }

        int index=0;
        while(index<81){
            if(board[index/9][index%9]=='.'){
                int r=index/9;
                int c=index%9;
                int g=r/3*3+c/3;
                boolean[] maybe=new boolean[9];
                int num_boolean=0,target=0;
                for(int i=0;i<9;i++){
                    num_boolean++;
                    maybe[i]=row[r][i]||col[c][i]||grid[g][i];
                    target=i;
                }
                if(num_boolean==1){
                    board[r][c]=(char) (target+1+'0');
                    row[r][target]=true;
                    col[c][target]=true;
                    grid[g][target]=true;
                    fill++;
                }
            }
            index++;
        }
        recur(0,board,row,col,grid,fill);
    }
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();

        ArrayList tmp=new ArrayList();
        tmp.add(1);
        tmp.add(3);
        out.println(tmp.contains(1));

        Solution037_Sudoku_Solver s=new Solution037_Sudoku_Solver();
        String str=scan.nextLine();
        int index=0;
        char[][] board=new char[9][9];
        for(int i=0;i<9;i++)
            board[i]=new char[9];
        for(int i=0;i<str.length()&&index<81;i++){
            char ch=str.charAt(i);
            if((ch>='0'&&ch<='9')||ch=='.'){
//                out.print(ch);
                board[index/9][index%9]=ch;
                index++;
            }
        }
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                out.print(board[i][j]);
            }
            out.println();
        }

        s.solveSudoku(board);
        out.println("Solved!\n\n");
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                out.print(board[i][j]);
            }
            out.println();
        }
    }
}
