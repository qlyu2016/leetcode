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
        
		System.out.println(test.nthUglyNumber(301));
	}
}

public class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> record = new ArrayList<>();
        
        record.add(1);
        if(n == 1){
        	return record.get(n - 1);
        }
        
        int i2 = 0, i3 = 0, i5 = 0;
        while(record.size() < n){
        	int m2 = record.get(i2) * 2, m3 = record.get(i3) * 3, m5 = record.get(i5) * 5;
        	int m = Math.min(m2, m3);
        	m = Math.min(m, m5);
        	if(m == m2){
        		i2 ++;
        	}
        	if(m == m3){
        		i3 ++;
        	}
        	if(m == m5){
        		i5 ++;
        	}
        	
        	record.add(m);
        }
        
        return record.get(record.size() - 1);
    }
}