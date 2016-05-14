package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        System.out.println(test.mySqrt(1));
	}
}

public class Solution {
    public int mySqrt(int x) {
        long result = 0;
        
        for(long i = 1; i <= x; i ++){
        	if(i * i <= x){
        		result = i;
        	}else{
        		break;
        	}
        }
        
        return (int)result;
    }
}