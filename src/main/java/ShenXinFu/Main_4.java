package ShenXinFu;

import java.util.Scanner;

import static java.lang.System.out;

/**
 *
 #include<bits/stdc++.h>

 #define maxn 10010

 using namespace std;

 inline int rd(){
 int x=0,y=1;char c=getchar();
 while(!isdigit(c)){if(c=='-')y=-y;c=getchar();}
 while(isdigit(c))x=x*10+c-'0',c=getchar();
 return x*y;
 }

 char c[maxn];
 int len;

 inline bool check(int x){
 int now=0;
 for(int i=1; i+x<=len; i++){
 if(c[i]==c[i+x])now++;
 else now=0;
 if(now==x)return true;
 }
 return false;
 }

 int main(){
 scanf("%s",c+1);
 len=strlen(c+1);
 int ans=0;
 for(int i=len/2; i>=1; i--){
 if(check(i)){
 ans=i;
 break;
 }
 }
 printf("%d\n",ans*2);
 */

public class Main_4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        out.println();



        }
    }