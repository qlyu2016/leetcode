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
        
		int n = 12;
		int[] primes = new int[]{2,7,13,19};
		System.out.println(test.nthSuperUglyNumber(n, primes));
	}
}

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> record = new ArrayList<>();
        record.add(1);
        if(n == 1){
        	return 1;
        }
        
    	int[] positions = new int[primes.length];
    	int[] numbers = new int[primes.length];
    	for(int i = 0; i < primes.length; i ++){
			numbers[i] = record.get(positions[i]) * primes[i];
		}
    	List<Integer> memory = new ArrayList<>();
    	while(record.size() < n){
    		for(int i = 0; i < memory.size(); i ++){
    			numbers[memory.get(i)] = record.get(positions[memory.get(i)]) * primes[memory.get(i)];
    		}
    		int min = Integer.MAX_VALUE;
    		memory.clear();
    		
    		for(int i = 0; i < primes.length; i ++){
    			if(numbers[i] < min){
    				min = numbers[i];
    				memory.clear();
    				memory.add(i);
    			}else if(numbers[i] == min){
    				memory.add(i);
    			}
    		}
    		for(int i = 0; i < memory.size(); i ++){
    			positions[memory.get(i)] ++;
    		}
    		
    		record.add(min);
    	}
    	
    	return record.get(record.size() - 1);
    }
}