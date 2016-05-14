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
import java.util.Set;
import java.util.Stack;
import java.util.Queue;
import java.util.TreeSet;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

//        char[][] board = {
//        		  {'A','B','C','E'},
//        		  {'S','F','C','S'},
//        		  {'A','D','E','E'}
//        };
//        String word = "ABCCED";
//		System.out.println(test.exist(board, word));
        
		int[][] board = {
				{1,1},
				{1,0}
		};
		test.gameOfLife(board);
	}
}

public class Solution {
	private int row;
	private int col;
	
    public void gameOfLife(int[][] board) {
    	this.row = board.length;
    	if(row == 0){
    		return ;
    	}
    	this.col = board[0].length;
        int[][] check = new int[row][col];
        
        for(int i = 0; i < row; i ++){
        	for(int j = 0; j < col; j ++){
        		int temp = this.nearLiveCells(i, j, board);
        		if(board[i][j] == 1 && (temp == 2 || temp == 3)){
        			check[i][j] = 1;
        		}else if(board[i][j] == 0 && temp == 3){
        			check[i][j] = 1;
        		}
        	}
        }
        
        for(int i = 0; i < row; i ++){
        	for(int j = 0; j < col; j ++){
        		board[i][j] = check[i][j];
        	}
        }
    }
    
    public int nearLiveCells(int i, int j, int[][] board){
    	int result = 0;
    	
    	if(i > 0){
    		if(j > 0){
    			if(board[i - 1][j - 1] == 1){
    				result ++;
    			}
    		}
    		if(board[i - 1][j] == 1){
				result ++;
			}
    		if(j < this.col - 1){
    			if(board[i - 1][j + 1] == 1){
    				result ++;
    			}
    		}
    	}
    	
    	if(i < this.row - 1){
    		if(j > 0){
    			if(board[i + 1][j - 1] == 1){
    				result ++;
    			}
    		}
    		if(board[i + 1][j] == 1){
				result ++;
			}
    		if(j < this.col - 1){
    			if(board[i + 1][j + 1] == 1){
    				result ++;
    			}
    		}
    	}
    	
    	if(j > 0){
    		if(board[i][j - 1] == 1){
			   result ++;
		    }
    	}
    	
    	if(j < this.col - 1){
    		if(board[i][j + 1] == 1){
 			   result ++;
 		    }
    	}
    	
    	
    	return result;
    }
}