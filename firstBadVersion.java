package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int n = 2126753390;
		System.out.println(test.firstBadVersion(n));
	}
}

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */

public class Solution extends VersionControl{
    public int firstBadVersion(int n) {
    	
    	return (int)firstBad(1, n);
    }
    
    public long firstBad(long start, long end){
    	
    	if(start == end){
    		return start;
    	}
    	
    	if(!this.isBadVersion((int)((start + end) / 2)) && this.isBadVersion((int)((start + end) / 2 + 1))){
    		return (start + end) / 2l + 1l;
    	}else if(this.isBadVersion((int)((start + end) / 2)) && this.isBadVersion((int)((start + end) / 2 + 1))){
    		return firstBad(start, (start + end) / 2l);
    	}else if(!this.isBadVersion((int)((start + end) / 2)) && !this.isBadVersion((int)((start + end) / 2 + 1))){
    		return firstBad((start + end) / 2l + 1l, end);
    	}else{
    		return -1;
    	}
    		
    }
    
    public boolean isBadVersion(int version){
    	if(version < 1702766719)
    		return false;
    	else
    		return true;
    }
}

class VersionControl{
	
}