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

//        int n = 2147483648;
//        System.out.println(test.hammingWeight(n));
        System.out.println(Integer.MAX_VALUE);
        
        
		
	}
}

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        if(n == 0){
        	return 0;
        }
        
        while(n != 0){
        	if((n ^ 1) % 2 == 0){
        		count ++;
        	}
        	n >>>= 1;
        }
        
        return count;
    }
}