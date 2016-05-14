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

		int[] nums1 = new int[1];
		nums1[0] = 0;
		int[] nums2 = {1};
		int m = 0;
		int n = 1;
		test.merge(nums1, m, nums2, n);
		for(int i = 0; i < m + n; i ++){
			System.out.print(nums1[i] + " ");
		}
	}
}

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mark2 = 0;
        List<Integer> temp = new ArrayList<>();
    	
        if(nums2.length == 0)
        	return ;
        
        for(int i = 0; i < m; i ++){
        	temp.add(nums1[i]);
        }
        
    	for(int i = 0; i < m + n; i ++){
    		if(mark2 < n && temp.size() > 0 && temp.get(0) < nums2[mark2]){
    			nums1[i] = temp.remove(0);
    		}else{
    			if(mark2 < n){
    			    nums1[i] = nums2[mark2];
    			    mark2 ++;
    			}else{
    				nums1[i] = temp.remove(0);
    			}
    		}
    	}
    }
}