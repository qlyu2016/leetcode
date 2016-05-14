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
        
		int[][] grid = {
				{1,0,0,0,1},
				{0,0,0,0,0},
				{0,0,1,0,0}
		};
		
		System.out.println(test.minTotalDistance(grid));
		
		
		
	}
}

public class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> hori = new ArrayList<>();
        List<Integer> verti = new ArrayList<>();
        if(grid.length == 0)
        	return 0;
        if(grid[0].length == 0)
        	return 0; 
        
        for(int i = 0; i < grid.length; i ++){
        	for(int j = 0; j < grid[0].length; j ++){
        		if(grid[i][j] == 1){
        		   hori.add(i);
        		   verti.add(j);
        		}
        	}
        }
        
        verti.sort(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1 - o2;
			}
        	
        });
        
        int result = 0;
        
        int x;
        if(hori.size() % 2 == 0)
            x = hori.get(hori.size() / 2 - 1);
        else
        	x = hori.get(hori.size() / 2);
        for(int i = 0; i < hori.size(); i ++){
        	result += Math.abs(x - hori.get(i));
        }
        
        int y;
        if(verti.size() % 2 == 0)
            y = verti.get(verti.size() / 2 - 1);
        else
        	y = verti.get(verti.size() / 2);
        for(int i = 0; i < verti.size(); i ++){
        	result += Math.abs(y - verti.get(i));
        }
        
        return result;
    }
}