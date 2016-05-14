package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();
        
        int n = 6;
        
        System.out.println(test.countAndSay(n));
	}
}

public class Solution {
    public String countAndSay(int n) {
        List<String> result = new ArrayList<String>();
        
        result.add("1");
        if(n == 1)
        	return result.get(0);
        
        for(int i = 1; i < n; i ++){
        	List<String> temp = new ArrayList<String>();
        	int count = 0;
        	while(count < result.size()){
        	    int tempNum = findSplit(result.subList(count, result.size()));
        	    temp.add(String.valueOf(tempNum));
        	    temp.add(result.get(count));
        	    count += tempNum;
        	}
        	
        	result = temp;
        }
        
        StringBuilder resultF = new StringBuilder();
        for(int i = 0; i < result.size(); i ++){
        	resultF.append(result.get(i));
        }
        
        return resultF.toString();
    }
    
    public int findSplit(List<String> subList){
    	if(subList.size() <= 0)
    		return -1;
    	if(subList.size() == 1)
    		return 1;
    	
    	String guide = subList.get(0);
    	int result = 1;
    	for(int i = 1; i < subList.size(); i ++){
    		if(subList.get(i).equals(guide)){
    			result = i + 1;
    		}else{
    			return result;
    		}
    	}
    	return result;
    }
}