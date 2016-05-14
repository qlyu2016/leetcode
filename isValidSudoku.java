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

		String[] board2 = {
				"..3..7.8.",
				".........",
				"6........",
				".5.......",
				".....257.",
				"..8......",
				"8..2....6",
				".3.9..14.",
				"1..17...."
		};
		char[][] board = new char[9][9];
		for(int i = 0; i < 9; i ++){
			board[i] = board2[i].toCharArray();
		}
		
		System.out.println(test.isValidSudoku(board));
	}
}

public class Solution {
    public boolean isValidSudoku(char[][] board) {
		for(int i = 0; i < 9; i ++){
			List<String> temp = new ArrayList<>();
			for(int j = 0; j < 9; j ++){
			    if(board[i][j] >= '1' && board[i][j] <= '9'){
				    String now = String.valueOf(board[i][j]);
			    	if(!temp.contains(now)){
					   temp.add(now);
				    }else{
				    	return false;
				    }
			    }
			}
		}
		
		for(int i = 0; i < 9; i ++){
			List<String> temp = new ArrayList<>();
			for(int j = 0; j < 9; j ++){
			    if(board[j][i] >= '1' && board[j][i] <= '9'){
				    String now = String.valueOf(board[j][i]);
			    	if(!temp.contains(now)){
					   temp.add(now);
				    }else{
				    	return false;
				    }
			    }
			}
		}
		
		for(int i = 0; i < 3; i ++){
			for(int j = 0; j < 3; j ++){
				List<String> temp = new ArrayList<>();
				for(int k = 0; k < 3; k ++){
					for(int l = 0; l < 3; l ++){
						if(board[3 * i + k][3 * j + l] >= '1' && board[3 * i + k][3 * j + l] <= '9'){
							String now = String.valueOf(board[3 * i + k][3 * j + l]);
							if(!temp.contains(now)){
								temp.add(now);
							}else{
								return false;
							}
						}
					}
				}
			}
		}
		
    	return true;        
    }
}