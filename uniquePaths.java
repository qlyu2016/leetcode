package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        
		int m = 51;
		int n = 9;
        System.out.println(test.uniquePaths(m, n));

	}
}

public class Solution {
    public int uniquePaths(int m, int n) {
        int result = 1;
        List<Integer> dividor = new ArrayList<>();
        
        if(m < n){
        
            for(int i = 1; i <= m - 1; i ++){
        	    dividor.add(i);
            }
        
            for(int i = n; i <= m + n - 2; i ++){
                for(int j = 0; j < dividor.size(); j ++){
            	    if(result % dividor.get(j) == 0){
            		   result /= dividor.get(j);
            		   dividor.remove(j);
            	    }
                }
        	    result *= i;
            }
        }else{
        	
            for(int i = 1; i <= n - 1; i ++){
        	    dividor.add(i);
            }
        
            for(int i = m + n - 2; i >= m; i --){
                for(int j = 0; j < dividor.size(); j ++){
            	    if(result % dividor.get(j) == 0){
            		   result /= dividor.get(j);
            		   dividor.remove(j);
            	    }
                }
        	    result *= i;
            }
        }
        
        for(int i = 0; i < dividor.size(); i ++){
        	result /= dividor.get(i);
        }
        
        return result;
    }
}