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

		String s = " 1";
		System.out.println(test.reverseWords(s));
	}
}

public class Solution {
    public String reverseWords(String s) {
        if(!s.contains(" "))
        	return s;
        
        String[] words = s.split(" ");
        if(words.length == 0)
        	return "";
        List<String> result = new ArrayList<>();
        
        for(int i = words.length - 1; i >= 0; i --){
        	if(!words[i].equals(""))
        	   result.add(words[i]);
        }
        
        StringBuffer resultF = new StringBuffer("");
        for(int i = 0; i < result.size() - 1; i ++){
        	resultF.append(result.get(i));
        	resultF.append(" ");
        }
        resultF.append(result.get(result.size() - 1));
        
        return resultF.toString();
    }
}