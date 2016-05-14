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

		String s = "";
		String p = "c*c*";
		System.out.println(test.isMatch(s, p));
	}
}

public class Solution {
    public boolean isMatch(String s, String p) {
        if(s.length() == 0 && p.length() == 0)
        	return true;
        
        if(s.length() == 0){
        	if(p.length() > 1 && p.charAt(1) == '*'){
        		return isMatch(s, p.substring(2, p.length()));
        	}else{
        		return false;
        	}
        }
        
        if(p.length() > 1 && p.charAt(1) == '*'){
        	while(s.length() != 0 && p.length() != 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))){
        		if(isMatch(s, p.substring(2, p.length()))){
        			return true;
        		}
        		s = s.substring(1, s.length());
        	}
        	
        	return isMatch(s, p.substring(2, p.length()));
        	
        }else if(s.length() != 0 && p.length() != 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0))){
        	
        	return isMatch(s.substring(1, s.length()), p.substring(1, p.length()));
        	
        }
        
        return false;
    }
}