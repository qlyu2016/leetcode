package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int numRows = 5;
		List<List<Integer>> result = test.generate(numRows);
		for(int i = 0; i < result.size(); i ++){
			List<Integer> temp = result.get(i);
			for(int j = 0; j < temp.size(); j ++){
				System.out.print(temp.get(j) + " ");
			}
			System.out.println();
		}
		
	}
}

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows < 1)
        	return result;
        
        List<Integer> now = new ArrayList<>();
        now.add(1);
        result.add(now);
        
        for(int i = 2; i <= numRows; i ++){
        	now = oneFloor(now);
        	result.add(now);
        }
        
        return result;
    }
    
    public List<Integer> oneFloor(List<Integer> input){
    	List<Integer> result = new ArrayList<>();
    	result.add(input.get(0));
    	
    	for(int i = 0; i < input.size() - 1; i ++){
    		result.add(input.get(i) + input.get(i + 1));
    	}
    	
    	result.add(input.get(input.size() - 1));
    	
    	return result;
    }
}