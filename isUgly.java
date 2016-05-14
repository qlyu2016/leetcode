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

		System.out.println(test.isUgly(1));
		
	}
}

public class Solution {
    public boolean isUgly(int num) {
    	if(num == 0)
    		return false;
        if(num == 1) 
        	return true;
        
        while(num != 1){
        	if(num % 5 == 0){
        		num /= 5;
        	}else if(num % 3 == 0){
        		num /=3;
        	}else if(num % 2 == 0){
        		num /= 2;
        	}else{
        		return false;
        	}
        }
        
        return true;
    }
}