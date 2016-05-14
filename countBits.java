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
 
		int num = 5;
        		
		int[] result = test.countBits(num);
		for(int i = 0; i < result.length; i ++){
			System.out.print(result[i] + " ");
		}
	}
}

public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        
        for(int i = 0; i <= num; i ++){
        	result[i] = this.bits(i);
        }
        
        return result;
    }
    
    public int bits(int number){
    	int result = 0;
    	while(number != 0){
    		if(number % 2 == 1){
    			result ++;
    		}
    		number /= 2;
    	}
    	
    	return result;
    }
}