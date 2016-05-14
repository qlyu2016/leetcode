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

		int numRows = 0;
		List<Integer> result = test.getRow(numRows);
		for(int i = 0; i < result.size(); i ++){
			System.out.print(result.get(i) + " ");
		}
		
	}
}

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        
        for(int i = 1; i <= rowIndex; i ++){
        	result = oneFloor(result);
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