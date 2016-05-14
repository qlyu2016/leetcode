package leetcode;

import java.util.ArrayList;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();
        
		int[] nums1 = {};
		int[] nums2 = {2, 3};
		
		System.out.println(test.findMedianSortedArrays(nums1, nums2));
	}
}


public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int number1 = nums1.length;
        int number2 = nums2.length;
        int[] numsAll = new int[number1 + number2];
        
        int i = 0, j = 0;
        while(i < number1 && j < number2){
        	if(nums1[i] < nums2[j]){
        		numsAll[i + j] = nums1[i];
        		i ++;
        	}else{
        		numsAll[i + j] = nums2[j];
        		j ++;
        	}
        }
        
        if(i == number1){
        	while(j < number2){
        	   numsAll[i + j] = nums2[j];
        	   j ++;
        	}
        }
        
        if(j == number2){
        	while(i < number1){
        	   numsAll[i + j] = nums1[i];
        	   i ++;
        	}
        }
         
        if(numsAll.length >= 2){
           return (double) (numsAll[(numsAll.length - 1) / 2] + numsAll[numsAll.length / 2]) / 2.0d;
        }else{
           return numsAll[0];
        }
    }
}