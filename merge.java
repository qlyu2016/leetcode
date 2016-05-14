package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,4));
        intervals.add(new Interval(0,4));

//        intervals.add(new Interval(8,10));
//        intervals.add(new Interval(15,18));
        
        List<Interval> result = test.merge(intervals);
        
        for(int i = 0; i < result.size(); i ++){
            Interval temp = result.get(i); 
        	System.out.println("[" + temp.start + "," + temp.end + "]");
        }
	}
}

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        int count = 0;
        
        Collections.sort(intervals,new Comparator<Interval>(){
			@Override
			public int compare(Interval a, Interval b) {
				// TODO Auto-generated method stub
	        	return a.start - b.start;
			}
        });
        
        while(count < intervals.size() - 1){
        	List<Interval> subResult = mergeTwo(intervals.remove(count), intervals.remove(count));
        	intervals.addAll(count, subResult);
        	if(subResult.size() == 2){
        		count ++;
        	}
        }
        
        return intervals;
    }
    
	public static boolean CompareByStart(Interval i1, Interval i2){
		if(i1.start < i2.start)
			return true;
		else 
			return false;
	} 
    
    public List<Interval> mergeTwo(Interval interval1, Interval interval2){
    	List<Interval> result = new ArrayList<>();
    	int x1, y1, x2, y2;
    	
    	x1 = interval1.start;
    	y1 = interval1.end;
    	x2 = interval2.start;
    	y2 = interval2.end;
    	
    	if(x2 <= y1){
    		if(y2 <= y1){
    			Interval temp = new Interval(x1, y1);
    			result.add(temp);
    		}else{
    			Interval temp = new Interval(x1, y2);
    			result.add(temp);
    		}
    	}else{
    		result.add(interval1);
    		result.add(interval2);
    	}
    	
    	return result;
    }
}

class Interval{
	int start;
	int end;
	Interval(){start = 0; end = 0;}
	Interval(int s, int e){start = s; end = e;}
}