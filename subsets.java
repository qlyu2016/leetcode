package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();
        
		int[] nums = {1,2,3};
		List<List<Integer>> result = test.subsets(nums);
		
        for(int i = 0; i < result.size(); i ++){
            List<Integer> temp = result.get(i); 
        	for(int j = 0; j < temp.size(); j ++){
        		System.out.print(temp.get(j) + ",");
        	}
        	System.out.println();
        }

	}
}

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> para = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i ++){
        	para.add(nums[i]);
        }
        
        result.add(new ArrayList<Integer>());
        
        for(int i = 1; i <= nums.length; i ++){
           List<List<Integer>> subResult = recurve(para, i);
           result.addAll(subResult);
        }
        
        return result;
    }
    
    public List<List<Integer>> recurve(List<Integer> nums, int k){
    	List<List<Integer>> result = new ArrayList<>();
    	
    	if(k == 1){
    		for(int i = 0; i < nums.size(); i ++){
    			List<Integer> temp = new ArrayList<>();
    			temp.add(nums.get(i));
    			result.add(temp);
    		}
    		return result;
    	}
    	
    	for(int i = 0; i < nums.size(); i ++){
    		List<Integer> tempPara = new ArrayList<Integer>();
    		tempPara.addAll(nums.subList(i, nums.size()));
    		tempPara.remove(0);
    		List<List<Integer>> tempResult = recurve(tempPara, k - 1);
    		for(int j = 0; j < tempResult.size(); j ++){
    			List<Integer> item = tempResult.get(j);
    			item.add(0, nums.get(i));
    			result.add(item);
    		}
    	}
    	
    	return result;
    }
}

/*
   自己的代码顺序不对，不能AC
   下面代码可以AC
*/

    public class Solution {  
        void dfs(int [] number_array, int start, int number, List<Integer> array, List<List<Integer>> result) {  
            if(number==array.size()) {  
                result.add(new ArrayList<Integer>(array));  
                return;  
            }  
            for(int i=start;i<number_array.length;i++) {  
                array.add(number_array[i]);  
                dfs(number_array,i+1,number,array,result);  
                array.remove(array.size()-1);  
            }  
        }  
        public List<List<Integer>> subsets(int[] S) {  
              List<List<Integer>> result = new ArrayList<>();  
              List<Integer> array = new ArrayList<Integer>();  
              result.add(array);  
              if(S==null) {  
                  return result;  
              }  
              Arrays.sort(S);  
              for(int i=1;i<=S.length;i++) {  
                  array.clear();  
                  dfs(S,0,i,array,result);  
              }  
              return result;  
        }  
    }  
