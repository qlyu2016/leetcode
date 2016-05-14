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

		String s = "a";
		String t = "a";
		System.out.println(test.isAnagram(s, t));
	}
}

public class Solution {
    public boolean isAnagram(String s, String t) {
        List<String> role = new ArrayList<>();
        
        if(s.length() != t.length())
        	return false;
        
        for(int i = 0; i < s.length(); i ++){
        	role.add(String.valueOf(s.charAt(i)));
        }
        
        for(int i = 0; i < t.length(); i ++){
        	if(!role.remove(String.valueOf(t.charAt(i))))
        	     return false;
        }
        
        return true;
    }
}