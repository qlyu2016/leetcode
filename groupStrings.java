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
import java.util.Set;
import java.util.Stack;
import java.util.Queue;
import java.util.TreeSet;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		String[] strings = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		List<List<String>> result = test.groupStrings(strings);
		
		for(int i = 0; i < result.size(); i ++){
			List<String> temp = result.get(i);
			for(int j = 0; j < temp.size(); j ++){
				System.out.print(temp.get(j) + " ");
			}
			System.out.println();
		}
	}
}

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> record = new HashMap<>();
        
        for(int i = 0; i < strings.length; i ++){
        	String present = strings[i];
        	String temp = "";
        	for(int j = 0; j < present.length() - 1; j ++){
        		if(present.charAt(j + 1) >= present.charAt(j)){
        			temp = temp.concat(String.valueOf(present.charAt(j + 1) - present.charAt(j))).concat(" ");
        		}else{
        			temp = temp.concat(String.valueOf(present.charAt(j + 1) + 26 - present.charAt(j))).concat(" ");
        		}
        	}
        	if(record.get(temp) == null){
        	    List<String> tmp = new ArrayList<>();
        	    tmp.add(present);
        		record.put(temp, tmp);
        	}else{
        		record.get(temp).add(present);
        	}
        }
        
        Iterator<List<String>> it = record.values().iterator();
        while(it.hasNext()){
            result.add(it.next());
        }
        
        return result;
    }
}