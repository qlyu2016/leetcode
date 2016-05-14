package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

        String s = " ";
        System.out.println(test.lengthOfLastWord(s));
	}
}

public class Solution {
    public int lengthOfLastWord(String s) {
        String[] splitString = s.split(" ");
//        
//        for(int i = 0; i < splitString.length; i ++){
//            System.out.println(i + ":" + splitString[i]);
//        }
        
        if(splitString.length > 0)
            return splitString[splitString.length - 1].length();
        else
        	return 0;
    }
}