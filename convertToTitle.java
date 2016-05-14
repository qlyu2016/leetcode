package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        int n = 1;
        System.out.println(test.convertToTitle(n));
	}
}

public class Solution {
	private String[] alb = {
			"A","B","C","D","E","F",
			"G","H","I","J","k","L",
			"M","N","O","P","Q","R",
			"S","T","U","V","W","X",
			"Y","Z"
	}; 
    public String convertToTitle(int n) {
        List<String> subRe = new ArrayList<>();
        
        while(n != 0){
        	subRe.add(alb[(n - 1) % 26]);
        	n = (n - 1) / 26;
        }
        
        StringBuffer result = new StringBuffer("");
        while(subRe.size() > 0){
           result.append(subRe.remove(subRe.size() - 1));
        }
        
        return result.toString();
        
    }
}