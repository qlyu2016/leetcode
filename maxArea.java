package leetcode;

import java.util.ArrayList;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int[] height = {1,2,3,4,1};
		System.out.println(test.maxArea(height));
	}
}

public class Solution {
    public int maxArea(int[] height) {
        int container = 0;
    	int left = 0; 
    	int right = height.length - 1;
    	
    	while(left < right){
    		int area = Math.min(height[left], height[right]) * (right - left);
    		if(area > container)
    			container = area;
    		
    		if(height[left] < height[right]){
    			left ++;
    		}else{
    			right --;
    		}
    	}
    	
    	return container;
    }
}