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

        int[] coins = {2};
        int amount = 3;
        
        System.out.print(test.coinChange(coins, amount));
		
	}
}

public class Solution {
	private int result = Integer.MAX_VALUE;
	
    public int coinChange(int[] coins, int amount) {
    	Arrays.sort(coins);
        int[] dps = new int[amount + 1];
        Arrays.fill(dps, Integer.MAX_VALUE - 1);
        if(amount == 0)
        	return 0;
        
        for(int i = 0; i < coins.length; i ++){
        	for(int j = 1; j * coins[i] <= amount; j ++){
        	   dps[j * coins[i]] = Math.min(Math.min(dps[(j - 1) * coins[i]] + 1, j), dps[j * coins[i]]);
        	}
        }
        
        for(int i = 1; i <= amount; i ++){
        	int min = Integer.MAX_VALUE;
        	for(int j = 0; j < coins.length; j ++){
        		if(i >= coins[j]){
        			min = Math.min(min, dps[i - coins[j]]);
        		}else{
        			break;
        		}
        	}
        	if(min < Integer.MAX_VALUE){
        	    dps[i] = Math.min(min + 1, dps[i]);
        	}
        }
        
        if(dps[amount] == Integer.MAX_VALUE - 1)
            return -1;
        else
        	return dps[amount];
    }
}