package ByteDance.BigData2018_3;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/1f8d61e3090644d8996fdec01694d3cf
 来源：牛客网

 有一个推箱子的游戏, 一开始的情况如下图:

 上图中, '.' 表示可到达的位置, '#' 表示不可到达的位置，其中 S 表示你起始的位置, 0表示初始箱子的位置, E表示预期箱子的位置，你可以走到箱子的上下左右任意一侧, 将箱子向另一侧推动。如下图将箱子向右推动一格;
 ..S0.. -> ...S0.
 注意不能将箱子推动到'#'上, 也不能将箱子推出边界;
 现在, 给你游戏的初始样子, 你需要输出最少几步能够完成游戏, 如果不能完成, 则输出-1。

 输入描述:

 第一行为2个数字,n, m, 表示游戏盘面大小有n 行m 列(5< n, m < 50);
 后面为n行字符串,每行字符串有m字符, 表示游戏盘面;


 输出描述:

 一个数字,表示最少几步能完成游戏,如果不能,输出-1;
 示例1
 输入

 3 6
 .S#..E
 .#.0..
 ......
 输出

 11
 */
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.System.out;

public class Main_2 {
    public static boolean check(char[][] board,int r,int c,int target_i,int target_j){
        if(target_i<0||target_j<0||target_i>=r||target_j>=c) return false;
        char ch=board[target_i][target_j];
        if(ch=='#'||ch=='0') return false;//
        return true;
    }
    public static int SD(char[][] board,int r0,int c0,int rt,int ct){
        int n=board.length,m=board[0].length;
        if(!check(board,n,m,rt,ct)) return -1;
        if(r0==rt&&c0==ct) return 0;
        boolean[][] visit=new boolean[n][m];
        Queue<int[]> q=new LinkedList<int[]>();
        int[] cur={r0,c0,0};
        visit[r0][c0]=true;
        q.offer(cur);
        while(!q.isEmpty()){
            cur=q.poll();
            if(check(board,n,m,cur[0]+1,cur[1])&&visit[cur[0]+1][cur[1]]==false){
                if(cur[0]+1==rt&&cur[1]==ct) return cur[2]+1;
                visit[cur[0]+1][cur[1]]=true;
                int[] tmp={cur[0]+1,cur[1],cur[2]+1};
                q.offer(tmp);
            }
            if(check(board,n,m,cur[0]-1,cur[1])&&visit[cur[0]-1][cur[1]]==false){
                if(cur[0]-1==rt&&cur[1]==ct) return cur[2]+1;
                visit[cur[0]-1][cur[1]]=true;
                int[] tmp={cur[0]-1,cur[1],cur[2]+1};
                q.offer(tmp);
            }
            if(check(board,n,m,cur[0],cur[1]+1)&&visit[cur[0]][cur[1]+1]==false){
                if(cur[0]==rt&&cur[1]+1==ct) return cur[2]+1;
                visit[cur[0]][cur[1]+1]=true;
                int[] tmp={cur[0],cur[1]+1,cur[2]+1};
                q.offer(tmp);
            }
            if(check(board,n,m,cur[0],cur[1]-1)&&visit[cur[0]][cur[1]-1]==false){
                if(cur[0]==rt&&cur[1]-1==ct) return cur[2]+1;
                visit[cur[0]][cur[1]-1]=true;
                int[] tmp={cur[0],cur[1]-1,cur[2]+1};
                q.offer(tmp);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt(),m=scan.nextInt();
        scan.nextLine();
        char[][] board=new char[n][m];
        int [][] visit=new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                visit[i][j]=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            board[i]=scan.nextLine().toCharArray();
        }

        int h_i=-1,h_j=-1;
        int b_i=-1,b_j=-1;
        int e_i=-1,e_j=-1;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(board[i][j]=='S'){
                    h_i=i;
                    h_j=j;
                }
                if(board[i][j]=='0'){
                    b_i=i;
                    b_j=j;
                }
                if(board[i][j]=='E'){
                    e_i=i;
                    e_j=j;
                }
            }


        int max=Integer.MAX_VALUE;
        Queue<int[]> q=new LinkedList<int[]>();
        int[] s={b_i,b_j,h_i,h_j,0};
        visit[b_i][b_j]=0;
        board[b_i][b_j]='.';
        board[h_i][h_j]='.';
        q.offer(s);

//        out.println("终点：("+e_i+","+e_j+")");
        while(!q.isEmpty()){
            int[] cur=q.poll();
            board[cur[0]][cur[1]]='0';
            if(cur[4]>=max){
                board[cur[0]][cur[1]]='.';
                continue;
            }
//            out.println("箱子所在位置: ("+cur[0]+","+cur[1]+")");
            if(check(board,n,m,cur[0]+1,cur[1])){//&&visit[cur[0]+1][cur[1]]==false
                int add=SD(board,cur[2],cur[3],cur[0]-1,cur[1])+1;
                if(add>0&&cur[4]+add<max) {
//                    out.println("人原来的位置: ("+cur[2]+","+cur[3]+") , 现在的位置(向下推): ("+(cur[0])+","+cur[1]+"), 要走 "+(add)
//                            +"步"+" , 已走 "+cur[4]+"步 ， 箱子现在位置: ("+(cur[0]+1)+","+cur[1]+")");

                    if (board[cur[0] + 1][cur[1]] == 'E') {
                        max = cur[4] + add;
//                        out.println("更新max "+max);
                    }
                    else{
                        int[] tmp = {cur[0] + 1, cur[1], cur[0], cur[1], cur[4] + add};
                        if(visit[cur[0]+1][cur[1]]>cur[4] + add) {
                            visit[cur[0] + 1][cur[1]] = cur[4] + add;
                            q.offer(tmp);
                        }
                    }
                }
            }
            if(check(board,n,m,cur[0]-1,cur[1])){//&&visit[cur[0]-1][cur[1]]==false
                int add=SD(board,cur[2],cur[3],cur[0]+1,cur[1])+1;
                if(add>0&&cur[4]+add<max) {
//                    out.println("人原来的位置: ("+cur[2]+","+cur[3]+") , 现在的位置(向上推): ("+(cur[0])+","+cur[1]+"), 要走 "+
//                            (add)+"步"+" , 已走 "+cur[4]+"步 ， 箱子现在位置: ("+(cur[0]-1)+","+cur[1]+")");
                    if (board[cur[0] - 1][cur[1]] == 'E') {
                        max = cur[4] + add;
//                        out.println("更新max "+max);
                    }
                    else {
                        int[] tmp = {cur[0] - 1, cur[1], cur[0], cur[1], cur[4] + add};
                        if(visit[cur[0]-1][cur[1]]>cur[4] + add) {
                            visit[cur[0] - 1][cur[1]] = cur[4] + add;
                            q.offer(tmp);
                        }

                    }
                }
            }
            if(check(board,n,m,cur[0],cur[1]+1)){//&&visit[cur[0]][cur[1]+1]==false
                int add=SD(board,cur[2],cur[3],cur[0],cur[1]-1)+1;
                if(add>0&&cur[4]+add<max) {
//                    out.println("人原来的位置: ("+cur[2]+","+cur[3]+") , 现在的位置(向右): ("+(cur[0])+","+(cur[1])+"), 要走 "+
//                            (add)+"步"+" , 已走 "+cur[4]+"步 ， 箱子现在位置: ("+cur[0]+","+(cur[1]+1)+")");
                    if (board[cur[0]][cur[1] + 1] == 'E') {
                        max = cur[4] + add;
//                        out.println("更新max "+max);
                    }
                    else {
                        int[] tmp = {cur[0], cur[1] + 1, cur[0], cur[1], cur[4] + add};
                        if(visit[cur[0]][cur[1]+1]>cur[4] + add) {
                            visit[cur[0]][cur[1]+1] = cur[4] + add;
                            q.offer(tmp);
                        }
                    }
                }
            }
            if(check(board,n,m,cur[0],cur[1]-1)){//&&visit[cur[0]][cur[1]-1]==false
                int add=SD(board,cur[2],cur[3],cur[0],cur[1]+1)+1;
                if(add>0&&cur[4]+add<max) {
//                    out.println("人原来的位置: ("+cur[2]+","+cur[3]+") , 现在的位置(向左推): ("+(cur[0])+","+(cur[1])+"), 要走 "+
//                            (add)+"步"+" , 已走 "+cur[4]+"步 ， 箱子现在位置: ("+cur[0]+","+(cur[1]-1)+")");
                    if (board[cur[0]][cur[1] - 1] == 'E') {
                        max = cur[4] + add;
//                        out.println("更新max "+max);
                    }
                    else {

                        int[] tmp = {cur[0], cur[1] - 1, cur[0], cur[1], cur[4] + add};
                        if(visit[cur[0]][cur[1]-1]>cur[4] + add) {
                            visit[cur[0]][cur[1]-1] = cur[4] + add;
                            q.offer(tmp);
                        }
                    }
                }
            }
            board[cur[0]][cur[1]]='.';
        }
        out.println(max==Integer.MAX_VALUE?-1:max);
    }
}

/**
 3 6
 .S#..E
 .#.0..
 ......
 */

/**

27 39
.................................#.##..
...#............#.#....................
........#..............................
...............#...#...................
....#.....#..#.........................
.....................##....#...........
.....#..................#...##.#.......
.#.#.....#.......#.....................
................###....#.......#...#...
...............#.#....0..#......#......
...#.................##......#.........
....#.........#..#.....................
....#......#.....#.....................
......................#................
.#........#.........#...#............#.
.#..#.#....#....#...#.........#........
.#.....#............#......#...#..#....
...#.S.........##.#.........#....E.....
.......................#..#....#.....#.
......#........................#.......
..#..................#...........#.....
....................#.........#......#.
...........##..........................
..#.....#..............#...............
.............#............##.#.........
.............#............##.#.........
.......#....#.#....#.........#.......#.
#.....................#................
 */