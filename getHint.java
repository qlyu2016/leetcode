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

        String secret = "1807";
        String guess = "7810";
        
        System.out.println(test.getHint(secret, guess));
	}
}

public class Solution {
	List<Integer> hintS = new ArrayList<>();
	List<Integer> hintG = new ArrayList<>();
    public String getHint(String secret, String guess) {
    	int bull = 0;
    	int cow = 0;
        for(int i = 0; i < secret.length(); i ++){
        	int s = secret.charAt(i) - '0';
        	int g = guess.charAt(i) - '0';
        	if(s == g){
        		bull ++;
        	}else{
        		hintS.add(s);
        		hintG.add(g);
        	}
        }
        
        cow = countCows(hintS, hintG);
        
        StringBuffer result = new StringBuffer("");
        result.append(String.valueOf(bull));
        result.append("A");
        result.append(String.valueOf(cow));
        result.append("B");
        
        return result.toString();
    }
    
    public int countCows(List<Integer> secret, List<Integer> guess){
    	int result = 0;
    	int length = secret.size();
        
    	for(int i = 0; i < length; i ++){
    		int temp = secret.get(i);
    		if(guess.remove((Integer)temp)){
    			result ++;
    		}
    	}
    	
    	return result;
    }
}