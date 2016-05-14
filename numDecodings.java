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

//        char[][] board = {
//        		  {'A','B','C','E'},
//        		  {'S','F','C','S'},
//        		  {'A','D','E','E'}
//        };
//        String word = "ABCCED";
//		System.out.println(test.exist(board, word));
		String s = "11";
		System.out.println(test.numDecodings(s));
	}
}

public class Solution {
	public int numDecodings(String s) {
	     if(s.length() == 0) return 0;
	     if(s.charAt(0) == '0') return 0;
	     if(s.length() == 1) return s.charAt(0) > '0' ? 1:0;
	     int dp[] = new int[s.length()+1];
	     dp[0] = dp[1] = 1;
	     for(int i=2; i<=s.length(); i++){
	           dp[i] = dp[i-1];
	           if(s.charAt(i-1) == '0')
	                if (s.charAt(i-2) == '1' || s.charAt(i-2) == '2')
	                    dp[i] = dp[i-2];
	                else return 0;
	           else if(s.charAt(i-2) == '0'){
	                dp[i] = dp[i-1];
	                continue;
	           }
	           else if(s.charAt(i-2) < '2' || (s.charAt(i-2) == '2' && s.charAt(i-1) < '7') )
	                dp[i] += dp[i-2];
	     }
         return dp[s.length()];
	 }
}