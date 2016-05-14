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
 
		int[][] costs = new int[][]{{15,17,15,20,7,16,6,10,4,20,7,3,4},{11,3,9,13,7,12,6,7,5,1,7,18,9}};
        		
		System.out.println(test.minCostII(costs));
	}
}

public class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;
        if(prices.length == 0){
        	return 0;
        }
        
        for(int i = 0; i < prices.length; i ++){
        	if(prices[i] < min){
        		min = prices[i];
        	}
        	if(result < prices[i] - min){
        		result = prices[i] - min;
        	}
        }
        
        return result;
    }
}