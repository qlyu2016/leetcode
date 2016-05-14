package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;
import java.util.TreeSet;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

//        char[][] board = {
//        		  {'A','B','C','E'},
//        		  {'S','F','C','S'},
//        		  {'A','D','E','E'}
//        };
//        String word = "ABCCED";
//		System.out.println(test.exist(board, word));
        
		Interval[] intervals = new Interval[]{new Interval(5,8), new Interval(6,8)};
		
		System.out.println(test.minMeetingRooms(intervals));
		
		
		
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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length == 0){
        	return 0;
        }
        if(intervals.length == 1){
        	return 1;
        }
        
        Arrays.sort(intervals, new Comparator<Interval>(){

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start - o2.start;
			}
        	
        });
        
        List<List<Interval>> record = new ArrayList<>();
        for(int i = 0; i < intervals.length; i ++){
        	if(record.size() == 0){
        		List<Interval> temp = new ArrayList<>();
        		temp.add(intervals[i]);
        		record.add(temp);
        	}else{
        		int j = 0;
        		for( ; j < record.size(); j ++){
        			List<Interval> now = record.get(j);
        			if(now.get(now.size() - 1).end <= intervals[i].start){
        				now.add(intervals[i]);
        				break;
        			}
        		}
        		if(j == record.size()){
        			List<Interval> intense = new ArrayList<>();
        			intense.add(intervals[i]);
        			record.add(intense);
        		}
        	}
        }
        
        return record.size();
    }
}

class Interval{
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}