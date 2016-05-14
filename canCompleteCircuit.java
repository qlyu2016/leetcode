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

        int[] gas = {};
        int[] cost = {};
        System.out.println(test.canCompleteCircuit(gas, cost));
	}
}

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i ++){
        	int volume = 0;
        	int j = 0;
        	for(; j < gas.length; j ++){
        		volume = volume + gas[(i + j) % gas.length] - cost[(i + j) % gas.length];
        		if(volume < 0)
        			break;
        	}
        	if(j == gas.length)
        		return i;
        }
        
        return -1;
    }
}