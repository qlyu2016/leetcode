package leetcode;

import java.util.ArrayList;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		System.out.println(test.reverse(-2147483648));
	}
}

public class Solution {
    public int reverse(int x) {
        if(x == 0)
        	return x;
        
        if(x == Integer.MAX_VALUE || x == Integer.MIN_VALUE)
        	return 0;
        
    	long res = 0;  
        
        int check;
        int tgt;
        if(x < 0){
        	check = -1;
        	tgt = Math.abs(x);
        }else{
        	check = 1;
        	tgt = x;
        }
        
        while(tgt != 0)  
        {  
            res = res*10 + tgt % 10;  
            tgt /= 10;  
        } 
        
        if(res > Integer.MAX_VALUE)
           return 0;
        else
           return (int) (check * res);
    }
}