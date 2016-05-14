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
import java.util.Stack;


class Run{
	public static void main(String args[]){
		Solution test = new Solution();

		
	}
}

class MyQueue {
	Stack<Integer> in = new Stack<>();
	Stack<Integer> out = new Stack<>();
	
    // Push element x to the back of queue.
    public void push(int x) {
        in.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
    	int inlength = in.size();
        for(int i = 0; i < inlength; i ++){
        	out.push(in.pop());
        }
        out.pop();
        int outlength = out.size();
        for(int i = 0; i < outlength; i ++){
        	in.push(out.pop());
        }
    }

    // Get the front element.
    public int peek() {
    	int inlength = in.size();
        for(int i = 0; i < inlength; i ++){
        	out.push(in.pop());
        }
        int result = out.peek();
        for(int i = 0; i < inlength; i ++){
        	in.push(out.pop());
        }
        return result;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(in.size() == 0)
        	return true;
        else 
        	return false;
    }
}