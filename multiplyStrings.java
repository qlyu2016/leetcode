package leetcode;

import java.util.ArrayList;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();
		
		System.out.println(test.multiply("214", "37568"));
	}
}


public class Solution {
    public String multiply(String num1, String num2) {
        char[] number1 = num1.toCharArray();
        char[] number2 = num2.toCharArray();
        int[] result = new int[number1.length + number2.length];
        
        for(int i = 0; i < number1.length; i ++){
        	for(int j = 0; j < number2.length; j ++){
        		int temp = Integer.parseInt(String.valueOf(number1[number1.length - i - 1])) 
        				* Integer.parseInt(String.valueOf(number2[number2.length - j - 1]));
        		result[(number1.length - i - 1) + (number2.length - j - 1) + 1] += temp;
        	}
        }
        
        int digit =  0;
        int ten = 0;
        for(int i = number1.length + number2.length - 1; i >= 0 ; i --){
        	  result[i] += ten;
        	  digit = result[i] % 10;
        	  ten = result[i] / 10;
        	  result[i] = digit;
        }
        
        int count = 0;
        for(int i = 0; i < result.length; i ++){
        	if(result[i] != 0){
        		break;
        	}else{
        		count ++;
        	}
        }
        
        char[] resultF = new char[result.length];
        for(int i = 0; i < result.length; i ++){
        	resultF[i] = (char) (result[i] + 48);
        }
        if(count < result.length){
            return String.valueOf(resultF, count, result.length - count);
        }else{
        	return String.valueOf('0');
        }
    }
}