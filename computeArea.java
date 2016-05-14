package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int A = -2;
		int B = -2;
		int C = 2;
		int D = 2;
		int E = 3;
		int F = 3;
		int G = 4;
		int H = 4;
		System.out.println(test.computeArea(A, B, C, D, E, F, G, H));
	}
}

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int rect1 = (D - B) * (C - A);
        int rect2 = (H - F) * (G - E);
        int overlap = 0;
        if(isOverlap(A, B, C, D, E, F, G, H))
            overlap = (Math.min(C, G) - Math.max(E, A)) * (Math.min(D, H) - Math.max(B, F));
        
        return rect1 + rect2 - overlap;
    }
    
    public boolean isOverlap(int A, int B, int C, int D, int E, int F, int G, int H){
         if(A >= G)
        	 return false;
         if(B >= H)
        	 return false;
         if(C <= E)
        	 return false;
         if(D <= F)
        	 return false;
         
         return true;
    }
}