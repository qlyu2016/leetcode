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

        String s = "AA";
        System.out.println(test.titleToNumber(s));
	}
}

public class Solution {
	
    public int titleToNumber(String s) {
    	int result = 0;
    	
        for(int i = 0; i < s.length(); i ++){
        	result = result * 26 + s.charAt(i) - 'A' + 1;
        }
        
        return result;
    }
}