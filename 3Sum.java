package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/* 思路: 1.将数组排序，

          2.a 遍历 数组a[0]....a[n-1];         

          3.当 a=a[i]  时   后面的问题 就是 :  a[i+1] 到 a[n-1]中  a[left]+a[right] =-a  （编程之美 2.12 快速寻找满足条件的两个数  ）      

                       记 a[left]=a[i+1]     a[right]=a[n-1]   

   若 a[left]+a[right]  < -a ，left++; 

a[left]+a[right] > -a  ，right--;    

a[left]+a[right]=-a 记录下来，并left++; right--;

  4.还有一个问题 就是unique triplet,   所以 a=a[i] 要判断是否和a[i-1]相等，若相等，子问题已经解答。

                                                                              也要判断 a[left]和a[right]  是否和之前的相同，若相同，就已经判断过了。*/



class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int[] nums = {0,0,0,0};
		
		List<List<Integer>> result = test.threeSum(nums);
		for(int i = 0; i < result.size(); i ++){
			List<Integer> item = result.get(i);
			for(int j = 0; j < item.size(); j ++){
				System.out.print(item.get(j) + " ");
			}
			System.out.println();
		}
	}
}



public class Solution {
	List<List<Integer>> result = new ArrayList<List<Integer>>();
	
    public List<List<Integer>> threeSum(int[] nums) {

        
        Arrays.sort(nums);
        
        int length = nums.length;
        for(int i = 0; i < length - 2; i ++){
        	if(i > 0 && nums[i] == nums[i - 1]) continue;
        	find(nums, i + 1, length - 1, nums[i]);
        }
        
        return result;
    }
    
    public void find(int[] num, int begin, int end, int target){
    	int left = begin;
    	int right = end;
    	
    	while(left < right){
    		if(left > begin + 1 && num[left] == num[left - 1]){   
                left ++;  
                continue;  
            }  
    		
            if(right < num.length - 1 && num[right] == num[right + 1]){  
                right --;  
                continue;  
            }

    		if(num[left] + num[right] + target == 0){
    			List<Integer> temp = new ArrayList<Integer>();
    			
    			temp.add(target);
    			temp.add(num[left]);
    			temp.add(num[right]);
    			result.add(temp);
    			
    			right --;
    			left ++;
    		}else if(num[left] + num[right] + target < 0){
    			left ++;
    		}else{
    			right --;
    		}
    	}
    }
}