package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        
		List<List<Integer>> result = test.combine(4, 2);
		
        for(int i = 0; i < result.size(); i ++){
            List<Integer> temp = result.get(i); 
        	for(int j = 0; j < temp.size(); j ++){
        		System.out.print(temp.get(j) + ",");
        	}
        	System.out.println();
        }

	}
}

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> para = new ArrayList<>();
        
        for(int i = 1; i <= n; i ++){
        	para.add(i);
        }
        
        result = recurve(para, k);
        
        return result;
    }
    
    public List<List<Integer>> recurve(List<Integer> nums, int k){
    	List<List<Integer>> result = new ArrayList<>();
    	
    	if(k == 1){
    		for(int i = 0; i < nums.size(); i ++){
    			List<Integer> temp = new ArrayList<>();
    			temp.add(nums.get(i));
    			result.add(temp);
    		}
    		return result;
    	}
    	
    	for(int i = 0; i < nums.size(); i ++){
    		List<Integer> tempPara = new ArrayList<Integer>();
    		tempPara.addAll(nums.subList(i, nums.size()));
    		tempPara.remove(0);
    		List<List<Integer>> tempResult = recurve(tempPara, k - 1);
    		for(int j = 0; j < tempResult.size(); j ++){
    			List<Integer> item = tempResult.get(j);
    			item.add(0, nums.get(i));
    			result.add(item);
    		}
    	}
    	
    	return result;
    }
}