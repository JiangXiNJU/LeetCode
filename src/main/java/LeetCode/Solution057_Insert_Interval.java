package LeetCode;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

 You may assume that the intervals were initially sorted according to their start times.

 Example 1:

 Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 Output: [[1,5],[6,9]]
 Example 2:

 Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 Output: [[1,2],[3,10],[12,16]]
 Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */

import java.util.List;

/**
 * Definition for an interval.
 * */
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class Solution057_Insert_Interval {
    public int binarysearch(List<Interval> intervals,int target,int type){
        if(type==1){//find front pos
            if(intervals.size()==1){
                if(intervals.get(0).start<target) return 0;
                else  return -1;
            }
            if(intervals.get(intervals.size()-1).start<target) return intervals.size()-1;

            int f=0,b=intervals.size();
            while(f+1<b){
                int mid=(f+b)/2;
                if(intervals.get(mid).start<target) f=mid;
                else if(intervals.get(mid).start>target) b=mid;
                else return mid-1;
            }
            if(intervals.get(f).start<target) return f;
            else return f-1;
        }
        else{//find back pos
            if(intervals.size()==1){
                if(intervals.get(0).end<target) return 0;
                else  return -1;
            }
            if(intervals.get(intervals.size()-1).start<target) return intervals.size()-1;

            int f=0,b=intervals.size();
            while(f+1<b){
                int mid=(f+b)/2;
                if(intervals.get(mid).start<target) f=mid;
                else if(intervals.get(mid).start>target) b=mid;
                else return mid-1;
            }
            if(intervals.get(f).start<target) return f;
            else return f-1;
        }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        return intervals;
    }
}
