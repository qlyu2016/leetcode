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

		String s = "ab";
		String t = "aa";
		System.out.println(test.isIsomorphic(s, t));
	}
}

public class Solution {
	private HashMap<String, String> corres = new HashMap<>();
	private HashMap<String, String> correverse = new HashMap<>();
	
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
        	return false;
        }
        
        for(int i = 0; i < s.length(); i ++){
        	String sword = String.valueOf(s.charAt(i));
        	String tword = String.valueOf(t.charAt(i));
        	if(corres.get(sword) == null){
        		if(correverse.get(tword) == null){
        		   corres.put(sword, tword);
        		   correverse.put(tword, sword);
        		}else{
        			return false;
        		}
        	}else{
        		if(corres.get(sword).equals(tword)){
        			;
        		}else{
        			return false;
        		}
        	}
        }
        
        return true;
    }
}