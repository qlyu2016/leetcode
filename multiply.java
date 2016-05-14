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
        
		int[][] A = {
			 { 1, 0, 0},
		     {-1, 0, 3}
		};

		int[][] B = {
			 { 7, 0, 0 },
		     { 0, 0, 0 },
		     { 0, 0, 1 }
		};
		
		int[][] C = test.multiply(A, B);
		
		for(int i = 0; i < C.length; i ++){
			for(int j = 0; j < C[0].length; j ++){
				System.out.print(C[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}

class matrix{
	int i;
	int j;
	int val;
	public matrix(int i, int j, int val){
		this.i = i;
		this.j = j;
		this.val = val;
	}
}

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int row = A.length;
        int col = B[0].length;
        int count = A[0].length;
        int[][] result = new int[row][col];
        List<matrix> remainA = new ArrayList<>(); 
        List<matrix> remainB = new ArrayList<>(); 
        
        
        for(int i = 0; i < row; i ++){
        	result[i] = new int[col];
        	for(int j = 0; j < count; j ++){
        		if(A[i][j] != 0){
        			remainA.add(new matrix(i, j, A[i][j]));
        		}
        	}
        }
        
        for(int i = 0; i < count; i ++){
        	for(int j = 0; j < col; j ++){
        		if(B[i][j] != 0){
        			remainB.add(new matrix(i, j, B[i][j]));
        		}
        	}
        }
        
        for(int i = 0; i < remainA.size(); i ++){
        	for(int j = 0; j < remainB.size(); j ++){
        		matrix matrixa = remainA.get(i);
        		matrix matrixb = remainB.get(j);
        		if(matrixa.j == matrixb.i){
        			result[matrixa.i][matrixb.j] += matrixa.val * matrixb.val;
        		}
        	}
        }
        
        return result;
    }
}