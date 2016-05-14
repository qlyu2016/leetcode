package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        
		int[][] matrix = {
		                  {1,   3,  5,  7},
		                  {10, 11, 16, 20},
		                  {23, 30, 34, 50}
		            };
		int target = 3;
		
        System.out.println(test.searchMatrix(matrix, target));

	}
}

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowPosition = -1;
        if(matrix.length == 0)
        	return false;
        if(matrix[0].length == 0)
        	return false;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        if(target < matrix[0][0])
        	return false;
        if(target > matrix[row - 1][col - 1])
        	return false;
        
        for(int i = 0; i < row - 1; i ++){
        	if(target >= matrix[i][0] && target < matrix[i + 1][0]){
        		rowPosition = i;
        		break;
        	}
        }
        
        if(rowPosition > -1){
            for(int i = 0; i < col; i ++){
        	    if(target == matrix[rowPosition][i]){
        	    	return true;
        	    }
            }
        }else{
        	for(int i = 0; i < col; i ++){
        		if(target == matrix[row - 1][i]){
        			return true;
        		}
        	}
        }
        
        return false;
    }
}