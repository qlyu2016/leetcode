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

        System.out.println(test.countPrimes(10));
	}
}

public class Solution {
    public int countPrimes(int n) {
        int count = 0;
        
        for(int i = 2; i < n; i ++){
        	if(isPrime(i)){
        		count ++;
        	}
        }
        
        return count;
    }
    
    public boolean isPrime(int k){
    	for(int i = 2; i * i <= k; i ++){
    		if(k % i == 0){
    			return false;
    		}
    	}
    	
    	return true;
    }
}

/*上面那个超时，应该用Sieve of Eratosthenes algorithm来计算小于n的素数个数*/

public int countPrimes(int n) {
   boolean[] isPrime = new boolean[n];
   for (int i = 2; i < n; i++) {
      isPrime[i] = true;
   }
   // Loop's ending condition is i * i < n instead of i < sqrt(n)
   // to avoid repeatedly calling an expensive function sqrt().
   for (int i = 2; i * i < n; i++) {
      if (!isPrime[i]) continue;
      for (int j = i * i; j < n; j += i) {
         isPrime[j] = false;
      }
   }
   int count = 0;
   for (int i = 2; i < n; i++) {
      if (isPrime[i]) count++;
   }
   return count;
}