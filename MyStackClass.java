package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.Queue;


class Run{
	public static void main(String args[]){
//		Solution test = new Solution();

        MyStack test = new MyStack();
        test.push(1);
        test.push(2);
        System.out.println(test.top());
	}
}

class MyStack {
	private Queue<Integer> in = new LinkedList<>();
	private Queue<Integer> out = new LinkedList<>();
	
    // Push element x onto stack.
    public void push(int x) {
        in.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        
        int inlength = in.size();
        for(int i = 0; i < inlength - 1; i ++){
        	out.offer(in.poll());
        }
        in.poll();
        int outlength = out.size();
        for(int i = 0; i < outlength; i ++){
        	in.offer(out.poll());
        }
    }

    // Get the top element.
    public int top() {
    	int inlength = in.size();
        for(int i = 0; i < inlength - 1; i ++){
        	out.offer(in.poll());
        }
        int result = in.peek();
        out.offer(in.poll());
        for(int i = 0; i < inlength; i ++){
        	in.offer(out.poll());
        }
        return result;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(in.size() == 0)
        	return true;
        else 
        	return false;
    }
}