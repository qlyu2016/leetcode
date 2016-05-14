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
import java.util.Stack;
import java.util.Queue;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        String a = "1010";
        String b = "1011";
        System.out.println(test.addBinary(a, b));
	}
}

public class Solution {
    public String addBinary(String a, String b) {
    	int[] sum = new int[Math.max(a.length(), b.length()) + 1];
        
        for(int i = a.length() - 1; i >= 0; i --){
        	int temp = a.charAt(i) - '0';
        	sum[i - a.length() + sum.length] += temp;
        }
        
        for(int i = b.length() - 1; i >= 0; i --){
        	int temp = b.charAt(i) - '0';
        	sum[i - b.length() + sum.length] += temp;
        }
        
        int pro = 0;
        for(int i = sum.length - 1; i >=0; i --){
        	int digit;
    		sum[i] += pro;
    		
        	if(sum[i] >= 2){
        		pro = sum[i] / 2;
        		sum[i] %= 2; 
        	}else{
        		pro = 0;
        	}
        }
        
        StringBuffer result = new StringBuffer("");
        if(sum[0] == 0){
        	for(int i = 1; i < sum.length; i ++){
        		result.append(String.valueOf(sum[i]));
        	}
        	
        	return result.toString();
        }else{
        	for(int i = 0; i < sum.length; i ++){
        		result.append(String.valueOf(sum[i]));
        	}
        	
        	return result.toString();
        }
        
    }
}