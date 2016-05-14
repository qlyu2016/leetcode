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

		int[] nums = {121, 12};
		String result = test.largestNumber(nums);
		System.out.println(result);
		String myAns = "9890982796859533945694489385914909490268939893783988353818381081078070798278467605"
				+ "753674717423732172057100703268566806675867446698663655465116327630662656241622160385972"
				+ "590957845712568255295460542252084980481247984704445342833932390538463836369936643650363"
				+ "635753567351634623399329831633084302129702822745273269724652362236223132228121621320602"
				+ "0001921763154815181495141713801147114310901048";
		
		String ans =   "9890982796859533945694489385914909490268939893783988353818381081078070798278467605"
				+ "753674717423732172057100703268566806675867446698663655465116327630662656241622160385972"
				+ "590957845712568255295460542252084980481247984704445342833932390538463836369936643650363"
				+ "635753567351634623399329831633084302129702822745273269724652362236223132281221621320602"
				+ "0001921763154815181495141713801147114310901048";
		
		
//		for(int i = 0; i < myAns.length(); i ++){
//			if(myAns.charAt(i) != ans.charAt(i)){
//				System.out.println(i);
//			}
//		}
	}
}

public class Solution {
    public String largestNumber(int[] nums) {
    	List<Integer> temp = new ArrayList<>();
    	
    	for(int i = 0; i < nums.length; i ++){
    		temp.add(nums[i]);
    	}
    	
    	temp.sort(new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1.toString().length() == o2.toString().length())
				   return -o1.toString().compareTo(o2.toString());
				else{
					int common = Math.min(o1.toString().length(), o2.toString().length());
					if(-o1.toString().substring(0, common).compareTo(o2.toString().substring(0, common)) != 0)
					    return -o1.toString().substring(0, common).compareTo(o2.toString().substring(0, common));
					else{
						if(o1.toString().length() > common){
							if(o1.toString().charAt(common) > o1.toString().charAt(0))
								return -1;
							else if(o1.toString().charAt(common) < o1.toString().charAt(0))
								return 1;
							else{
								if(o1.toString().length() > common + 1){
									if(o1.toString().charAt(common + 1) > o1.toString().charAt(1))
										return -1;
									else if(o1.toString().charAt(common + 1) < o1.toString().charAt(1)){
										return 1;
									}else{
										return 0;
									}
								}else{
									if(o1.toString().charAt(1) > o2.toString().charAt(0))
										return 1;
									else if(o1.toString().charAt(1) < o2.toString().charAt(0))
										return -1;
									else
									    return 0;
								}
							}
						}else{
							if(o2.toString().charAt(common) > o2.toString().charAt(0))
								return 1;
							else if(o2.toString().charAt(common) < o2.toString().charAt(0))
								return -1;
							else{
								if(o2.toString().length() > common + 1){
									if(o2.toString().charAt(common + 1) > o2.toString().charAt(1))
										return 1;
									else if(o2.toString().charAt(common + 1) < o2.toString().charAt(1)){
										return -1;
									}else{
										return 0;
									}
								}else{
									if(o2.toString().charAt(1) > o1.toString().charAt(0))
										return -1;
									else if(o2.toString().charAt(1) < o1.toString().charAt(0))
										return 1;
									else
									    return 0;
								}
							}
						}
					}
				}
			}}
    	);
    	
    	StringBuffer result = new StringBuffer("");
    	for(int i = 0 ; i < temp.size(); i ++){
    		if(!result.toString().equals("") || temp.get(i) != 0 || i == temp.size() - 1)
    		   result.append(temp.get(i));
    	}
    	
    	return result.toString();
    }
}