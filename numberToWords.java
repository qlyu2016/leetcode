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

		int num = 1000000;
		System.out.println(test.numberToWords(num));
	}
}

public class Solution {
	HashMap<Integer, String> digit = new HashMap<>();
	HashMap<Integer, String> tens = new HashMap<>();
	HashMap<Integer, String> thousands = new HashMap<>();
	
	{
		digit.put(0, "Zero");
		digit.put(1, "One");
		digit.put(2, "Two");
		digit.put(3, "Three");
		digit.put(4, "Four");
		digit.put(5, "Five");
		digit.put(6, "Six");
		digit.put(7, "Seven");
		digit.put(8, "Eight");
		digit.put(9, "Nine");
		digit.put(10, "Ten");
		digit.put(11, "Eleven");
		digit.put(12, "Twelve");
		digit.put(13, "Thirteen");
		digit.put(14, "Fourteen");
		digit.put(15, "Fifteen");
		digit.put(16, "Sixteen");
		digit.put(17, "Seventeen");
		digit.put(18, "Eighteen");
		digit.put(19, "Nineteen");
		
		tens.put(2, "Twenty");
		tens.put(3, "Thirty");
		tens.put(4, "Forty");
		tens.put(5, "Fifty");
		tens.put(6, "Sixty");
		tens.put(7, "Seventy");
		tens.put(8, "Eighty");
		tens.put(9, "Ninety");
		
		thousands.put(3, "Hundred");
		thousands.put(4, "Thousand");
		thousands.put(7, "Million");
		thousands.put(10, "Billion");
	}
	
    public String numberToWords(int num) {
    	List<String> resultT = new ArrayList<>();
        String number = String.valueOf(num);
        StringBuffer result = new StringBuffer("");
        List<String> splitNum = new ArrayList<>();
        List<Integer> positionNum = new ArrayList<>();
        
        
        while(number.length() > 0){
        	int rest = (number.length() - 1) % 3 + 1;
        	splitNum.add(number.substring(0, rest));
        	positionNum.add((number.length() - 1) / 3 * 3 + 1);
        	number = number.substring(rest, number.length());
        }
        
        for(int i = 0; i < positionNum.size(); i ++){
        	String temp = numberThree(splitNum.get(i));
        	if(!temp.equals(""))
        	   resultT.add(temp);
        	if(thousands.get(positionNum.get(i)) != null && !temp.equals("")){
        		resultT.add(thousands.get(positionNum.get(i)));
        	}
        }
        
        for(int i = 0; i < resultT.size(); i ++){
        	result.append(resultT.get(i));
        	if(i < resultT.size() - 1)
        		result.append(" ");
        }
        
        return result.toString();
    }
    
    public String numberThree(String number){
    	StringBuffer result = new StringBuffer("");
    	if(number.length() == 1){
    		result.append(digit.get(number.charAt(0) - '0'));
    		return result.toString();
    	}
    	
    	if(number.length() == 2){
    		if(number.charAt(0) <= '1'){
    			result.append(digit.get(Integer.parseInt(number)));
    			return result.toString();
    		}else{
    			result.append(tens.get(number.charAt(0) - '0'));
    			if(number.charAt(1) - '0' > 0){
    				result.append(" ");
    			    result.append(digit.get(number.charAt(1) - '0'));
    			}
    			return result.toString();
    		}
    	}else{
    		if(number.charAt(0) - '0' != 0){
    		   result.append(digit.get(number.charAt(0) - '0'));
    		   result.append(" ");
			   result.append(thousands.get(3));
    		}
    		
    		if(number.charAt(1) <= '1'){
    			if(number.charAt(1) != '0' || number.charAt(2) != '0'){
    				if(number.charAt(0) - '0' != 0)
    				   result.append(" ");
    			    result.append(digit.get(Integer.parseInt(number.substring(1, number.length()))));
    			}
    			return result.toString();
    		}else{
				if(number.charAt(0) - '0' != 0)
    			   result.append(" ");
    			result.append(tens.get(number.charAt(1) - '0'));
    			if(number.charAt(2) - '0' > 0){
    				result.append(" ");
    			    result.append(digit.get(number.charAt(2) - '0'));
    			}
    			return result.toString();
    		}
    	}
    	
    }
}