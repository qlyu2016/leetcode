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

        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = test.findRepeatedDnaSequences(s);
        
        for(int i = 0; i < result.size(); i ++){
        	System.out.println(result.get(i));
        }
	}
}

public class Solution {

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<String>();  
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  
        int key = 0;  
        for (int i = 0; i < s.length(); i++) {  
            key = ((key << 3) | (s.charAt(i) & 0x7)) & 0x3fffffff;  
            if (i < 9) continue;  
            if (map.get(key) == null) {  
                map.put(key, 1);  
            } else if (map.get(key) == 1) {  
                result.add(s.substring(i - 9, i + 1));  
                map.put(key, 2);  
            }  
        }  
        return result;  
    }
   
}