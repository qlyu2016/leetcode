package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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
//		Solution test = new Solution();

        MedianFinder test = new MedianFinder();
        test.addNum(2);
        System.out.println(test.findMedian());
        test.addNum(3);
        System.out.println(test.findMedian());
        
	}
}

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return sum(nestedList, 1);
    }
    
    public int sum(List<NestedInteger> nestedList, int depth){
    	if(nestedList.size() == 0){
        	return 0;
        }
        
        int result = 0;
        for(int i = 0; i < nestedList.size(); i ++){
        	if(nestedList.get(i).isInteger()){
        		result += nestedList.get(i).getInteger() * depth;
        	}else{
        		result += sum(nestedList.get(i).getList(), depth + 1);
        	}
        }
        
        return result;
    }
}