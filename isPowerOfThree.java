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
import java.util.Stack;
import java.util.Queue;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int n = 1;
		
		System.out.println(test.trailingZeroes(n));
	}
}

public class Solution {
    public boolean isPowerOfThree(int n) {
        if(n == 0)
        	return false;
    	
    	while(n % 3 == 0){
        	n /= 3;
        }
    	
    	if(n == 1)
    		return true;
    	else
    		return false;
    }
}