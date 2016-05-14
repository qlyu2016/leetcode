package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        System.out.println(test.climbStairs(45));
        System.out.println(test.calC(31, 14));
	}
}

public class Solution {
    public int climbStairs(int n) {
        int result = 0;
    	int countTwo = n / 2;
    	
    	for(int i = 0; i <= countTwo; i ++){
    		int temp;
    		if(n - 2 * i > i){
    		   temp = calC(n - i, i);
    		}else{
    		   temp = calC(n - i, n - 2 * i);
    		}
    		System.out.println(n - i + "," + i + ":" + temp);
    		result += temp;
    	}
    	
    	return result;
    }
    
    public int calC(int n, int r){
    	long result = 1;
    	List<Integer> dividor = new ArrayList<>();
    	
        for(int i = 1; i <= r; i ++){
    	    dividor.add(i);
        }
    
        for(int i = n; i >= n - r + 1; i --){
    	    for(int j = 0; j < dividor.size(); j ++){
        	    if(result % dividor.get(j) == 0){
        		   result /= dividor.remove(j);
        	    }
            }
        	result *= i;
        }
        
        for(int i = 0; i < dividor.size(); i ++){
        	result /= dividor.get(i);
        }
        
        return (int)result;
    }
}