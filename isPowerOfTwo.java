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

		System.out.println(test.isPowerOfTwo(-16));
	}
}

public class Solution {
    public boolean isPowerOfTwo(int n) {
        
    	if(n <= 0)
    		return false;
    	
    	while(n > 1){
    		if(n % 2 == 0)
    			n = n / 2;
    		else
    			return false;
    	}
    	
    	return true;
    }
}