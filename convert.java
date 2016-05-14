package leetcode;

import java.util.ArrayList;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		System.out.println(test.convert("PAYPALISHIRING", 3));
	}
}

public class Solution {
    public String convert(String s, int numRows) {
        char[][] result = new char[numRows][s.length()];
        char[] schars = s.toCharArray();
        int round = 2 * numRows - 2;
        char[] resultF = new char[s.length()];
        
        if(numRows == 1){
        	return s;
        }
        
        int i = 0;
        while(i < schars.length){
        	int turn = i / round;
        	int order = i % round;
        	if(order < numRows){
        		result[order][(numRows - 1) * turn] = schars[i];
        	}else{
        		result[2 * numRows - 2 - order][(numRows - 1) * turn + order + 1 - numRows] = schars[i];
        	}
        	i ++;
        }
        
        int count = 0;
        for(i = 0; i < numRows; i ++){
        	for(int j = 0; j < s.length(); j ++){
        		if(result[i][j] != 0){
        			resultF[count] = result[i][j];
        			count ++;
        		}
        	}
        }
        
        return String.valueOf(resultF);
    }
}