package leetcode;

import java.util.*;



public class Solution {
    public List<String> letterCombinations(String digits) {
    	List<String> result = new ArrayList();
    	if(digits.isEmpty()) {    
            return result;  
        } 
    	
        char number[] = new char[digits.length()];
        char map[][] = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},
        		{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},
        		{'w','x','y','z'}};
        int k = digits.length()-1;  
        
        while(k >= 0) {  
            k = digits.length() - 1;  
            char[] charTemp = new char[digits.length()];  
            for(int i = 0; i < digits.length(); i ++) {  
                charTemp[i] = map[digits.charAt(i)-'0'][number[i]];  
            }  
            
            result.add(new String(charTemp));  
            while(k>=0) {  
                if( number[k] < (map[digits.charAt(k) - '0'].length - 1)) {  
                    number[k]++;  
                    break;  
                } else {  
                    number[k] = 0;  
                    k --;  
                }  
            }  
        } 
        
        return result;
    }
}