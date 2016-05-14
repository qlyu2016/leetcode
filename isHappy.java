package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int n = 1;
        System.out.println(test.isHappy(n));
	}
}

public class Solution {
    public boolean isHappy(int n) {
        List<String> pre = new ArrayList<>();
        pre.add(String.valueOf(n));
        int number = 0;
        
        if(n == 1)
        	return true;
        
        while(number != 1){
            number = 0;
        	for(int i = 0; i < pre.get(pre.size() - 1).length(); i ++){
        		number += (pre.get(pre.size() - 1).charAt(i) - '0') * (pre.get(pre.size() - 1).charAt(i) - '0');
        	}
        	if(pre.indexOf(String.valueOf(number)) != -1){
        		return false;
        	}else{
        		pre.add(String.valueOf(number));
        	}
        }
        
        return true;
    }
}