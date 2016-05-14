package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.Queue;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(2);
//		root.right.left = new TreeNode(3);
//		root.left.left = new TreeNode(2);
//		root.left.left.left = new TreeNode(1);
//		root.left.left.right = new TreeNode(4);
//		root.left.left.right.left = new TreeNode(3);
		
		int[][] obstacleGrid = {
				 {0, 1},
				 {0, 0}
		};
		
		System.out.println(test.uniquePathsWithObstacles(obstacleGrid));
	}
}

public class Solution {
	
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null)
        	return 0;
    	int row = obstacleGrid.length;
    	if(row == 0)
    		return 0;
        int col = obstacleGrid[0].length;
        int[][] path = new int[row][col];
        
        boolean check = true;
        for(int j = 0; j < col; j ++){
        	if(obstacleGrid[0][j] == 1){
        		check = false;
        	}
        	if(check){
        		path[0][j] = 1;
        	}else{
        		path[0][j] = 0;
        	}
        }
        
        check = true;
        for(int i = 0; i < row; i ++){
        	if(obstacleGrid[i][0] == 1){
        		check = false;
        	}
        	if(check){
        		path[i][0] = 1;
        	}else{
        		path[i][0] = 0;
        	}
        }
        
        for(int i = 1; i < row; i ++){
        	for(int j = 1; j < col; j ++){
        		if(obstacleGrid[i][j] == 1){
        			path[i][j] = 0;
        		}else{
        		    path[i][j] = path[i - 1][j] + path[i][j - 1];
        		}
        	}
        }
        
        return path[row - 1][col - 1];
    }
}