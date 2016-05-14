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

        int n = 43261596;
        System.out.println(test.reverseBits(n));
	}
}

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        
        for(int i = 1; i != 0; i <<= 1){
        	result <<= 1;
        	if(n % 2 != 0){
        		result |= 1;
        	}
        	n >>= 1;
        }
        
        return result;
    }
}