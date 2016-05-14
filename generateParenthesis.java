package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;




class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		int n = 3;
		List<String> result = test.generateParenthesis(n);
		
		for(int i = 0; i < result.size(); i ++){
			System.out.println(result.get(i));
		}
	}
}


//顺序不一致，不能AC
public class Solution {
	private String parenL = "(";
	private String parenR = ")";
	
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        String paren = parenL.concat(parenR);
        String except = "";
        for(int i = 0; i < n; i ++){
        	except = except.concat(paren);
        }
        
        if(n == 1){
        	result.add(parenL.concat(parenR));
        	return result;
        }else{
            List<String> temp = generateParenthesis(n - 1);
            
            for(int i = 0; i < temp.size(); i ++){
            	result.add(parenL.concat(temp.get(i)).concat(parenR));
            	result.add(parenL.concat(parenR).concat(temp.get(i)));
            	result.add(temp.get(i).concat(parenL).concat(parenR));
            }
            result.remove(except);
            return result;
        }
    }
}

//AC
public class Solution {  
    private List<String> list = new ArrayList<String>();  
          
    public List<String> generateParenthesis(int n) {  
        run("", n, 0);  
        return list;  
    }  
          
    // l 为剩余左括号数，r为剩余未匹配的右括号数目  
    public void run(String str, int l, int r) {  
        if (l == 0 && r == 0) {  
            list.add(str);  
            return;  
        }  
        if (l > 0) {  
            String s = str + "(";  
            run(s, l-1, r+1);  
        }  
        if (r > 0) {  
            String s = str + ")";  
            run(s, l, r-1);  
        }  
    }  
}  