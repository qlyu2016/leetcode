package leetcode;

import java.util.*;

public class Solution {
    public static int rob(int[] nums) {
        int[] input = nums;
    	int temp = 0;
    	int sum = 0;
    	
    	boolean[] jg ;
    	jg = new boolean[nums.length];
    	for(int i = 0; i < nums.length; i ++){
    		jg[i] = false;
    		sum = sum + input[i];
    	}
    	int result = 0;
    	
    	
    	int k = nums.length - 1;
    	while(k >= 0){
    		int max = 0;
        	int choose = 0;
    	    for(int i = 0; i < input.length; i ++){
    		     if(input[i] > max){
    		    	 max = input[i];
    		    	 choose = i;
    		     }
    	    }
    	         input[choose] = 0;
    		     if(choose > 0 && choose <input.length - 1 && jg[choose-1] != true && jg[choose + 1] != true ){
    		    	 temp = temp + max;
    		    	 jg[choose] = true;
    		     }else if(choose == 0 && choose < input.length - 1 && jg[choose + 1] != true){
    		    	 temp = temp + max;
    		    	 jg[choose] = true;
    		     }else if(choose == input.length - 1 && choose > 0 && jg[choose - 1] != true){
    		    	 temp = temp + max;
    		    	 jg[choose] = true;
    		     }else if(choose == input.length - 1 && choose == 0 && jg[choose] != true){
    		    	 jg[choose] = true;
    		    	 temp = temp + max;
    		     }
    	    
    	    
    	    k--;
    	    
    	}
    	if(temp > sum - temp)
    	   result = temp;
    	else
    		result = sum - temp;
    	
    	return result;
    }
   
    public static void main(String args[]){
    	int input[] = {2,3,2};
    	System.out.print(rob(input));
    }
}