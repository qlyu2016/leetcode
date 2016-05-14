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
				{1,2,0,3},
				{2,3,5,1},
				{1,1,1,1}
		};
		
		test.setZeroes(matrix);
		
		for(int i = 0; i < matrix.length; i ++){
			for(int j = 0; j < matrix[0].length; j ++){
				System.out.print(matrix[i][j] + ",");
			}
			System.out.println();
		}
	}
}

public class Solution {
    public void setZeroes(int[][] matrix) {
        List<Integer> rowZ = new ArrayList<Integer>();
        List<Integer> colZ = new ArrayList<Integer>();
        
        if(matrix.length == 0) return;
        if(matrix[0].length == 0) return;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        for(int i = 0; i < row; i ++){
        	for(int j = 0; j < col; j ++){
        		if(matrix[i][j] == 0){
        			addZero(i, rowZ);
        			addZero(j, colZ);
        		}
        	}
        }
        
        for(int i = 0; i < rowZ.size(); i ++){
        	int temp = rowZ.get(i);
        	for(int j = 0; j < col; j ++){
        		matrix[temp][j] = 0;
        	}
        }
        
        for(int i = 0; i < colZ.size(); i ++){
        	int temp = colZ.get(i);
        	for(int j = 0; j < row; j ++){
        		matrix[j][temp] = 0;
        	}
        }
    }
    
    public void addZero(int input, List<Integer> Z){
    	for(int i = 0; i < Z.size(); i ++){
    		if(input == Z.get(i)){
    			break;
    		}
    	}
    	
    	Z.add(input);
    }
}