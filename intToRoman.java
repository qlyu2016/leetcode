package leetcode;

import java.util.ArrayList;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		System.out.println(test.intToRoman(4));
	}
}

public class Solution {
    public String intToRoman(int num) {
    	List<String> result = new ArrayList<String>();
    	
        while(num >= 1000){
        	result.add("M");
        	num -= 1000;
        }
        
        if(num >= 900){
        	result.add("CM");
        	num -= 900;
        }
        
        if(num >= 800){
        	result.add("DCCC");
        	num -= 800;
        }
        
        if(num >= 700){
        	result.add("DCC");
        	num -= 700;
        }
        
        if(num >= 600){
        	result.add("DC");
        	num -= 600;
        }
        
        if(num >= 500){
        	result.add("D");
        	num -= 500;
        }
        
        if(num >= 400){
        	result.add("CD");
        	num -= 400;
        }
        
        if(num >= 300){
        	result.add("CCC");
        	num -= 300;
        }
        if(num >= 200){
        	result.add("CC");
        	num -= 200;
        }
        
        if(num >= 100){
        	result.add("C");
        	num -= 100;
        }
        
        if(num >= 90){
        	result.add("XC");
        	num -= 90;
        }
        
        if(num >= 80){
        	result.add("LXXX");
        	num -= 80;
        }
        
        if(num >= 70){
        	result.add("LXX");
        	num -= 70;
        }
        
        if(num >= 60){
        	result.add("LX");
        	num -= 60;
        }
        
        if(num >=50){
        	result.add("L");
        	num -= 50;
        }
        
        if(num >= 40){
        	result.add("XL");
        	num -= 40;
        }
        
        if(num >=30){
        	result.add("XXX");
        	num -= 30;
        }
        
        if(num >= 20){
        	result.add("XX");
        	num -= 20;
        }
        
        if(num >=10){
        	result.add("X");
        	num -= 10;
        }
        
        if(num >= 9){
        	result.add("IX");
        	num -= 9;
        }
        
        if(num >= 8){
        	result.add("VIII");
        	num -= 8;
        }
        
        if(num >= 7){
        	result.add("VII");
        	num -= 7;
        }
        
        if(num >= 6){
        	result.add("VI");
        	num -= 6;
        }
        
        if(num >= 5){
        	result.add("V");
        	num -= 5;
        }
        
        if(num >= 4){
        	result.add("IV");
        	num -= 4;
        }
        
        if(num >= 3){
        	result.add("III");
        	num -= 3;
        }
        
        if(num >= 2){
        	result.add("II");
        	num -= 2;
        }
        
        if(num >= 1){
        	result.add("I");
        	num -= 1;
        }
        
        String resultF = "";
        for(int i = 0; i < result.size(); i ++){
        	resultF = resultF.concat(result.get(i));
        }
        
        return resultF;
    }
}