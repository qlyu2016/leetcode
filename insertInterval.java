package leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();
		List<Interval> factor = new ArrayList<Interval>();
		List<Interval> result; 
		Interval inte1 = new Interval(1,5);
		//Interval inte2 = new Interval(3,5);
		//Interval inte3 = new Interval(6,7);
		//Interval inte4 = new Interval(8,10);
		//Interval inte5 = new Interval(12,16);
		Interval Newinte = new Interval(2,3);
        
		factor.add(inte1);
		//factor.add(inte2);
		//factor.add(inte3);
		//factor.add(inte4);
		//factor.add(inte5);
		result = test.insert(factor, Newinte);
		
		for(int i = 0; i < result.size(); i ++){
			System.out.println(result.get(i).start + "  " + result.get(i).end);
		}
	}
}



class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
}
 
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
       if(intervals == null || newInterval == null)
    	   return null;
       
       if(intervals.size() == 0){
    	   intervals.add(newInterval);
    	   return intervals;
       }
       
       ListIterator<Interval> it = intervals.listIterator();
       
       while(it.hasNext()){
    	   Interval tempInterval = it.next();
    	   
    	   if(tempInterval.start > newInterval.end){
    		   it.previous();
    		   it.add(newInterval);
    		   return intervals;
    	   }else{
    		   if(tempInterval.end < newInterval.start){
    			   continue;
    		   }else{
                   newInterval.start = Math.min(tempInterval.start, newInterval.start);  
                   newInterval.end   = Math.max(tempInterval.end, newInterval.end);  
                   it.remove();  
    		   }
    	   }
       }
       intervals.add(newInterval);
       return intervals;
    }
}