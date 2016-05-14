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

        int[] nums = {4,5,6,7,0,0,1,1,2,3};
        
        System.out.print(test.findMin(nums));
		
	}
}

public class Solution {
    public int maxProduct(String[] words) {
        int max = Integer.MIN_VALUE;
        if(words.length == 0)
        	return 0;
        int[] maps = new int[words.length];
        Arrays.sort(words, new Comparator(){

			@Override
			public int compare(Object arg0, Object arg1) {
				// TODO Auto-generated method stub
				return ((String)arg1).length() - ((String)arg0).length();
			}
        	
        });
        
        for(int i = 0; i < words.length; i ++){
        	int bits = 0;
        	for(int j = 0; j < words[i].length(); j ++){
        		char c = words[i].charAt(j);
        		bits = bits | (1 << (c - 'a'));
        	}
        	maps[i] = bits;
        }
        
        for(int i = 0; i < words.length - 1; i ++){
        	for(int j = i + 1; j < words.length; j ++){
        		if((maps[i] & maps[j]) == 0){
        			max = Math.max(max, words[i].length() * words[j].length());
        			break;
        		}
        	}
        }
        
        if(max == Integer.MIN_VALUE)
        	return 0;
        else 
        	return max;
    }
}