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

		System.out.println(test.countDigitOne(13));
	}
}

public class Solution {
    public int countDigitOne(int n) {
    	 int ones = 0;  
         for (long m = 1; m <= n; m *= 10) {  
             long a = n / m, b = n % m;  
             ones += (a + 8) / 10 * m;  
             if(a % 10 == 1) ones += b + 1;  
         }  
         return ones; 
    }
}