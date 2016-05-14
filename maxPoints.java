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
		
		Point[] points = new Point[]{
				new Point(2,3),
				new Point(3,3),
				new Point(-5,3)
		};
		
		System.out.println(test.maxPoints(points));
	}
}

/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    public int maxPoints(Point[] points) {
        if(points.length < 3)
        	return points.length;
        
        int result = 2;
        HashMap<Double, Integer> slope = new HashMap<>();
        
        for(int i = 0; i < points.length; i ++){
        	slope.clear();
        	int dup = 1;
        	for(int j = i + 1; j < points.length; j ++){
        		double deltax = points[j].x - points[i].x;
        		double deltay = points[j].y - points[i].y;
        		double temp = 0.0d;
        		if(deltax == 0 && deltay == 0){
        			dup ++;
        			continue;
        		}else if(deltax == 0){
        			temp = Integer.MAX_VALUE;
        		}else if(deltay == 0){
        		    temp = 0.0d;
        		}else{
        		    temp = deltay / deltax;
        		}
        		if(slope.get(temp) == null){
        			slope.put(temp, 1);
        		}else{
        			int count = slope.get(temp);
        			slope.put(temp, count + 1);
        		}
        	}
        	
        	if(slope.keySet().size() == 0){
        		result = result > dup ? result : dup;
        	}else{
        		for(double k : slope.keySet()){
        			result = result > (dup + slope.get(k)) ? result : (dup + slope.get(k));
        		}
        	}
        	
        }

    	return result;
    }
}

class Point{
	int x;
	int y;
	Point(){
		x = 0;
		y = 0;
	}
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}