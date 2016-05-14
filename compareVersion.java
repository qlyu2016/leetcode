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

		String version1 = "1";
		String version2 = "1.1";
		
		System.out.println(test.compareVersion(version1, version2));
	}
}

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ver1;
        String[] ver2;
        List<Integer> vers1 = new ArrayList<>();
        List<Integer> vers2 = new ArrayList<>();
        
    	if(version1.contains(".")){
    	    ver1 = version1.split("\\.");
    	    for(int i = 0; i < ver1.length; i ++){
    	    	vers1.add(Integer.parseInt(ver1[i]));
    	    }
    	}
    	else
    	{
    		vers1.add(Integer.parseInt(version1));
    	}
    	
    	if(version2.contains(".")){
            ver2 = version2.split("\\.");
            for(int i = 0; i < ver2.length; i ++){
    	    	vers2.add(Integer.parseInt(ver2[i]));
    	    }            
    	}
        else
        {
        	vers2.add(Integer.parseInt(version2));
        }
        
    	for(int i = 0; i < Math.max(vers1.size(), vers2.size()); i ++){
    		if(i < vers1.size() && i < vers2.size() && vers1.get(i) < vers2.get(i))
    			return -1;
    		else if(i < vers1.size() && i < vers2.size() && vers1.get(i) > vers2.get(i))
    			return 1;
    		else{
    			if(i >= vers1.size() && vers2.get(i) != 0)
    				return -1;
    			
    			if(i >= vers2.size() && vers1.get(i) != 0)
    				return 1;
    		}
    	}
        
    	return 0;
        
        
    }
}