package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();
        
		String s = "()[]{}";
		String s1 = "]";
		
        System.out.println(test.isValid(s1));
	}
}


public class Solution {
    public boolean isValid(String s) {
        List<String> temp = new ArrayList<String>();
        
        for(int i = 0; i < s.length(); i ++){
        	if(String.valueOf(s.charAt(i)).equals("(")
        			|| String.valueOf(s.charAt(i)).equals("[")
        			|| String.valueOf(s.charAt(i)).equals("{")){
        		temp.add(String.valueOf(s.charAt(i)));
        	}
        	
        	if(String.valueOf(s.charAt(i)).equals(")")){
        		if(temp.size() == 0)
        			return false;
        		if(temp.get(temp.size() - 1).equals("(")){
        			temp.remove(temp.size() - 1);
        		}else{
        			return false;
        		}
        	}
        	
        	if(String.valueOf(s.charAt(i)).equals("]")){
        		if(temp.size() == 0)
        			return false;
        		if(temp.get(temp.size() - 1).equals("[")){
        			temp.remove(temp.size() - 1);
        		}else{
        			return false;
        		}
        	}
        	
        	if(String.valueOf(s.charAt(i)).equals("}")){
        		if(temp.size() == 0)
        			return false;
        		if(temp.get(temp.size() - 1).equals("{")){
        			temp.remove(temp.size() - 1);
        		}else{
        			return false;
        		}
        	}
        }
        
        if(temp.size() == 0)
        	return true;
        else
        	return false;
    }
}