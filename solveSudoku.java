package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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

//		char[][] a = new char[][]{
//				{'a'},
//				{'b'},
//				{'c'}
//		};
//		char[][] b = new char[3][1];
//		for(int i = 0; i < 3; i ++){
//			b[i] = a[i].clone();
//		}
//		b[0][0] = '1';
//		System.out.println(a[0][0]);
		
		char[][] board = new char[9][9];
		String[] rows = new String[]{
				"53..7....",
				"6..195...",
				".98....6.",
				"8...6...3",
				"4..8.3..1",
				"7...2...6",
				".6....28.",
				"...419..5",
				"....8..79"
		};
		for(int i = 0; i < 9; i ++){
			board[i] = rows[i].toCharArray();
		}
		
		test.solveSudoku(board);
		for(int i = 0; i < 9; i ++){
			for(int j = 0; j < 9; j ++){
			     System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}

public class Solution {
	private char[][] result;
	
    public void solveSudoku(char[][] board) {
    	if(board == null || board.length == 0){
        	return;
        }
    	
    	solve(board, 0);
    	for(int i = 0; i < 9; i ++){
    		for(int j = 0; j < 9; j ++){
    			board[i][j] = this.result[i][j];
    		}
    	}
    }
    
    public boolean solve(char[][] board, int pos){
    	if(pos == 81){
    		this.result = board;
    		return true;
    	}
    	int i = pos / 9;
    	int j = pos % 9;
    	
    	if(board[i][j] == '.'){
    		for(int k = 1; k <= 9; k ++){
    			board[i][j] = (char) (k + '0');
    			if(check(board, i, j)){
    				char[][] temp = new char[9][9];
    				for(int count = 0; count < 9; count ++){
    					temp[count] = board[count].clone();
    				}
    				if(solve(temp, pos + 1)){
    					return true;
    				}
    			}
    		}
    	}else{
    		char[][] temp = board.clone();
    		for(int count = 0; count < 9; count ++){
				temp[count] = board[count].clone();
			}
    		if(solve(temp, pos + 1)){
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public boolean check(char[][] board, int row, int col){
    	
    	for(int i = 0; i < 9; i ++){
    		if(i != row && board[i][col] == board[row][col]){
    			return false;
    		}
    	}
    	
    	for(int j = 0; j < 9; j ++){
    		if(j != col && board[row][j] == board[row][col]){
    			return false;
    		}
    	}
    	
    	for(int k = 0; k < 3; k ++){
    		for(int l = 0; l < 3; l ++){
    			if((k + 3 * (row / 3) != row || l + 3 * (col / 3) != col) 
    					&& board[k + 3 * (row / 3)][l + 3 * (col / 3)] == board[row][col]){
    				return false;
    			}
    		}
    	}
    	
    	return true;
    }
}