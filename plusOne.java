package leetcode;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();
		int[] digits = {5,9,1};
		for(int i = 0; i < test.plusOne(digits).length; i ++){
		    System.out.print(test.plusOne(digits)[i]);
		}
        
	}
}



public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
    	int numbers = length - 1;
    	int bool = 0;
    	int[] result;
    	int jinjie = 0;
    	for(int i = 0; i < length; i ++){
    		if(digits[i] < 9){
    			bool = 0;
    			break;
    		}else{
    			bool = 1;
    		}
    			
    	}
    	if(bool == 1){
    	   result = new int[length + 1];
    	   for(int i = 0; i < length; i ++){
    		   if(i == 0)
    			   result[i] = 1;
    		   else
    			   result[i] = 0;
    	   }   
    	   return result;
    	}
    	else
    	   result = new int[length];
        
    	
    	while(numbers >= 0){
    		if(numbers == length - 1 && digits[numbers] + 1 == 10){
    			result[numbers] = 0;
    			numbers --;
    			jinjie = 1;
    		}else if(numbers < length - 1 && digits[numbers] + jinjie == 10){
    			result[numbers] = 0;
    			numbers --;
    			jinjie = 1;
    		}else if(numbers == length - 1 && digits[numbers] + 1 < 10){
    			result[numbers] = digits[numbers] + 1;
    			numbers --;
    			jinjie = 0;
    		}else{
    			result[numbers] = digits[numbers] + jinjie;
    			numbers --;
    			jinjie = 0;
    		}
    	}
    	
    	
    	return result;
    }
}