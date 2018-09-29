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

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.addAll;

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
    public int binarysearch(ArrayList<Interval> list,int target,int dir){
        int f=0,b=list.size()-1;
        while(f<=b){
            int mid_index=f+(b-f)/2;
            Interval mid=list.get(mid_index);
            if(mid.start<=target&&mid.end>=target) return mid_index;
            if(mid.end<target) f=mid_index+1;
            else b=mid_index-1;
        }
        if(dir==0) return f;
        else return f-1;
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> intervals1=new ArrayList<Interval>();
        intervals.addAll(intervals);
        int n=intervals.size();
        int start=binarysearch(intervals1,newInterval.start,0);
        int end=binarysearch(intervals1,newInterval.end,1);

        ArrayList<Interval> res=new ArrayList<Interval>();
        res.addAll(intervals1.subList(0,start));
        int real_start=newInterval.start<=intervals1.get(start).start?newInterval.start:intervals1.get(start).start;
        int real_end=newInterval.end>=intervals1.get(end).end?newInterval.end:intervals1.get(end).end;
        res.add(new Interval(real_start,real_end));
        res.addAll(intervals.subList(end+1,n));
        return res;
    }
}
