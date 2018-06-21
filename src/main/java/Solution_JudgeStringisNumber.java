import static java.lang.System.out;

/**
 * Created by cycy on 2018/5/24.
 */

public class Solution_JudgeStringisNumber {
    public boolean isNumeric(char[] str) {
        int len=str.length;
        if(len==0) return false;
        int index=0;
        //小数部分
        if(str[0]=='+'||str[0]=='-'){
            if(len==1) return false;
            index++;
        }
        while(index<len&&str[index]>='0'&&str[index]<='9') index++;
        if(index>=len) return true;
        if(str[index]=='.'){
            if(index+1>=len||str[index+1]<'0'||str[index+1]>'9') {
                return false;
            }
            index++;
            while(index<len&&str[index]>='0'&&str[index]<='9') index++;
            if(index>=len) return true;
        }
        out.println(index+" end Integer");
        //整数部分
        if(str[index]=='e'||str[index]=='E'){
            index++;
            if(index>=len) return false;
            if(str[index]=='+'||str[index]=='-'){
                index++;
                if(index>=len||str[index]<'0'||str[index]>'9') return false;
                while(index<len&&str[index]>='0'&&str[index]<='9') index++;
                if(index>=len) return true;
                else return false;
            }
            else if(str[index]>='0'&&str[index]<='9'){
                while(index<len&&str[index]>='0'&&str[index]<='9') index++;
                if(index>=len) return true;
            }
            return false;
        }
        return false;
    }
    public static void main(String[] args){
        out.println(-2%3);
        Solution_JudgeStringisNumber s=new Solution_JudgeStringisNumber();
        String str="123.456e+6";
        str="-.123";
        char[] chs=str.toCharArray();
        out.println(s.isNumeric(chs));
    }
}