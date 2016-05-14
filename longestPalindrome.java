package leetcode;

import java.util.ArrayList;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();
        
		System.out.println(test.longestPalindrome("ccc"));
	}
}

public class Solution {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        //type:sshh
        int mid1 = 0;
        int length1 = 0;
        //type:ssahh
        int mid2 = 0;
        int length2 = 0;
        
        for(int i = 1; i < chars.length; i ++){
        	if(chars[i - 1] == chars[i]){
        		int mid1temp = i;
        		int length1temp = 1;
        		while((mid1temp - length1temp) >= 0 && (mid1temp + length1temp - 1) <= chars.length - 1 
        				&& chars[mid1temp - length1temp] == chars[mid1temp + length1temp - 1]){
        			length1temp ++;
        		}
        		if(length1temp - 1 > length1){
        			length1 = length1temp - 1;
        			mid1 = mid1temp;
        		}
        	}
        }
        
        for(int i = 1; i < chars.length - 1; i ++){
        	if(chars[i - 1] == chars[i + 1]){
        		int mid2temp = i;
        		int length2temp = 1;
        		while((mid2temp - length2temp) >= 0 && (mid2temp + length2temp) <= chars.length - 1 
        				&& chars[mid2temp - length2temp] == chars[mid2temp + length2temp]){
        			length2temp ++;
        		}
        		if(length2temp - 1 > length2){
        			length2 = length2temp - 1;
        			mid2 = mid2temp;
        		}
        	}
        }
        
        if(2 * length1 > 2 * length2 + 1){
        	return String.valueOf(chars, mid1 - length1, 2 * length1);
        }else{
        	return String.valueOf(chars, mid2 - length2, 2 * length2 + 1);
        }
    }
}