package leetcode;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();
		System.out.print(test.myPow(34.00515, -3));
	}
}



public class Solution {
    public double myPow(double x, int n) {
    	int power;
    	if(n == 0)
    		return 1;
        if(n < 0)
        	 power = -n;
        else 
        	 power = n;
        int[] reminder = new int[(int) (Math.log((double)power)/Math.log(2.0)) + 1];
        double[] factor = new double[(int) (Math.log((double)power)/Math.log(2.0)) + 1];
        int temp = power;
        int i = 0;
        double result = 1;
        
        while(temp >= 1){
            if(temp % 2 == 0)
            	reminder[i] = 0;
            else 
            	reminder[i] = 1;
            i++;
            temp = temp / 2;
        }
        
        for(int j = 0; j < i; j ++){
        	if(j == 0)
        		factor[j] = x;
        	else
        		factor[j] = factor[j - 1] * factor[j - 1];
        } 
        
        for(int j = 0; j < i; j ++){
        	if(reminder[j] == 1)
        	   result = result * factor[j];
        	else
        	   result = result;
        }
        
    	if(n > 0)
            return result;
    	else
    		return 1/result;
    }
}