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

		System.out.println(test.addDigits(10));
		
	}
}

public class Solution {
    public int addDigits(int num) {
        int result = num;
        
    	while(result >= 10){
    		result = addOneStep(result);
    	}
    	
    	return result;
    }
    
    public int addOneStep(int num){
    	String number = String.valueOf(num);
    	int result = 0;
    	for(int i = 0; i < number.length(); i ++){
    		result += number.charAt(i) - '0';
    	}
    	
    	return result;
    }
}