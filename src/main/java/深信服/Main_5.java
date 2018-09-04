package 深信服;

import java.util.Scanner;

import static java.lang.System.out;

/**
 *#include<bits/stdc++.h>

 using namespace std;

 inline int rd(){
 int x=0,y=1;char c=getchar();
 while(!isdigit(c)){if(c=='-')y=-y;c=getchar();}
 while(isdigit(c))x=x*10+c-'0',c=getchar();
 return x*y;
 }

 struct node{
 int now,cnt;
 node(int x=0,int y=0){now=x,cnt=y;}
 };

 int n,ans;
 int a[11];
 queue<node>q;
 map<int,bool>mp;

 inline int zip(){
 int ret=0;
 for(int i=1; i<=n; i++)ret=ret*10+a[i];
 return ret;
 }

 inline void unzip(int x){
 int len=1;
 while(x){
 a[len++]=x%10;
 x/=10;
 }
 len--;
 for(int i=1,j=len; i<j; i++,j--)swap(a[i],a[j]);
 }

 inline void rev(int l,int r){
 for(int i=l,j=r; i<j; i++,j--)swap(a[i],a[j]);
 }

 int main(){
 n=rd();
 for(int i=1; i<=n; i++)a[i]=rd(),ans=ans*10+i;
 q.push(node(zip(),0));
 mp[zip()]=true;
 while(!q.empty()){
 int now=q.front().now,cnt=q.front().cnt;
 q.pop();
 if(now==ans){
 printf("%d\n",cnt);
 return 0;
 }
 for(int i=1; i<=n; i++){
 for(int j=i+1; j<=n; j++){
 unzip(now);
 rev(i,j);
 int num=zip();
 if(!mp[num])q.push(node(num,cnt+1)),mp[num]=true;
 }
 }
 }

 return 0;
 }
 */

public class Main_5 {
    public static int find(int[] nums,int target){
        for(int i=1;i<=target;i++){
            if(nums[i]==target) return i;
        }
        return 0;
    }
    public static void roate(int [] nums,int start,int end){
        int tmp=0;
        for(int i=start;i<=(start+end)/2;i++){
            tmp=nums[i];
            nums[i]=nums[end+start-i];
            nums[end+start-i]=tmp;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        out.println();
        int n=scan.nextInt();
        int [] nums=new int[n+1];
        for(int i=1;i<=n;i++)
            nums[i]=scan.nextInt();
        int time=0;
        int target=n;
        while(target>=1){
            int index=find(nums,target);
            if(index!=target){
                roate(nums,index,target);
                time++;
            }

            target--;
        }
        out.println(time);
    }
}