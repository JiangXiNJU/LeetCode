package LeetCode;

import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.out;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string s, int numRows);
 Example 1:

 Input: s = "PAYPALISHIRING", numRows = 3
 Output: "PAHNAPLSIIGYIR"
 Example 2:

 Input: s = "PAYPALISHIRING", numRows = 4
 Output: "PINALSIGYAHRPI"
 Explanation:

 P     I    N
 A   L S  I G
 Y A   H R
 P     I
 */
public class ZigZag_Conversion {
    public String convert(String s, int numRows) {
        if(s==null||s.length()<=2||numRows<=1) return s;
        char[] from=s.toCharArray();
        int len=from.length;
        ArrayList[] to=new ArrayList[numRows];
        for(int i=0;i<numRows;i++)
            to[i]=new ArrayList();
        out.println("end init");
        int row=0;
        boolean direct=true;
        for(int i=0;i<len;i++){
            to[row].add(from[i]);
            if(row==0) {
                direct=true;
                row=(row+1)%numRows;
            }
            else if(row==numRows-1){
                direct=false;
                row=row-1;
            }
            else{
                if(direct) row++;
                else row--;
            }
        }

        StringBuffer res=new StringBuffer();
        out.println("print");
        for(int i=0;i<numRows;i++){
            out.print(i+": ");
            for(int j=0;j<to[i].size();j++)
                out.print(to[i].get(j));
            out.println();
        }
        for(int i=0;i<numRows;i++){
            for(int j=0;j<to[i].size();j++)
                res.append(to[i].get(j));
        }
        out.println(res.toString());
        return res.toString();
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        out.println();

        String s=scan.nextLine();
        int rows=scan.nextInt();
        String res=new ZigZag_Conversion().convert(s,rows);
    }
}
