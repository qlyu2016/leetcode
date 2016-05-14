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

        String[] strs = {"eat"};
        String a = "eat";
        String b = "eatt";
        
        List<List<String>> result = test.groupAnagrams(strs);
        
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
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int[] maps = new int[strs.length];
        HashMap<Integer, Integer> relation = new HashMap<>();
        int count = 0;
        
        for(int i = 0; i < strs.length; i ++){
        	int represent = 0;
        	for(char j = 'a'; j <= 'z'; j ++){
        		int temp = count(j, strs[i]);
        		represent |= temp;
        		represent <<= 1;
        	}
        	maps[i] = represent;
        }
        
        for(int i = 0; i < strs.length; i ++){
        	if(relation.get(maps[i]) == null){
        		List<String> temp = new ArrayList<>();
        		temp.add(strs[i]);
        		result.add(temp);
        		relation.put(maps[i], count);
        		count ++;
        	}else{
        		result.get(relation.get(maps[i])).add(strs[i]);
        	}
        }
        
        for(int i = 0; i < result.size(); i ++){
        	result.get(i).sort(new Comparator(){

				@Override
				public int compare(Object a, Object b) {
					// TODO Auto-generated method stub
					return dictCompare((String)a, (String)b);
				}
        		
        	});
        }
        
        return result;
    }
    
    public int count(char one, String object){
    	int result = 0;
    	for(int i = 0; i < object.length(); i ++){
    		if(object.charAt(i) == one){
    			result ++;
    		}
    	}
    	
    	return result;
    }
    
    public int dictCompare(String a, String b){
    	int i = 0;
    	for(; i < Math.min(a.length(), b.length()); i ++){
    		if(a.charAt(i) < b.charAt(i)){
    			return -1;
    		}else if(a.charAt(i) > b.charAt(i)){
    			return 1;
    		}else{
    			continue;
    		}
    	}
    	
    	if(i < a.length()){
    		return 1;
    	}
    	
    	if(i < b.length()){
    		return -1;
    	}else{
    		return 0;
    	}
    }
}



//AC答案，自己的答案顺序不同，思路相同。

public class Solution{
public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
        char[] ar = s.toCharArray();
        Arrays.sort(ar);
        String sorted = String.valueOf(ar);
        List<String> list = map.get(sorted);
        if (list == null) list = new ArrayList<String>();
        list.add(s);
        map.put(sorted, list);
    }
    List<List<String>> res = new ArrayList<>();
    for (List<String> l : map.values()) {
        Collections.sort(l);
        res.add(l);
    }
    return res;
}
}