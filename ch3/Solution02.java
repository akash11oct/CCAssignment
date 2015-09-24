package practice.CCAssignment.ch3;

import java.util.Stack;
import practice.CCAssignment.ch3.StacksNQueuesUtility.*;

/**
 * This class implements a stack that keeps track of minimum element in stack at
 * every step. This helps to return the minimum element in stack in O(1) time.
 *
 * This class uses an extra stack to keep track of minimum element.
 * @author Akash Gandotra
 */
class StackMin extends Stack<Integer> {

    //Keeps track of minimum element at all times.
    private Stack<Integer> minStack = new Stack<Integer>();

    /**
     * Push an item onto stack.
     * Push the item on minStack as well if the elements is equal or lesser than
     * the element at the currently minimum element.
     * @param item element to be pushed
     */
    public void push(int item) {
        super.push(item);
        if (minStack.empty() || item <= minStack.peek()) {
            minStack.push(item);
        }
    }

    /**
     * Pop the element at top of stack.
     * If the element popped is at the top of minStack as well, pop it from 
     * minStack also. This helps the minStack to have the minimum element at the
     * top when this element is popped from our stack.
     * 
     * @return element at top of stack.
     */
    public Integer pop() {
        int val = super.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
        return val;
    }

    /**
     * Return the minimum element in stack in O(1) time by simply returning the 
     * element at top of minStack.
     * 
     * @return the minimum element in stack
     * @throws EmptyStackException 
     */
    public int min() throws EmptyStackException {
        if (minStack.empty()) {
            throw new EmptyStackException();
        }
        return minStack.peek();
    }

    /**
     * Display the contents of stack and minStack at any moment.
     */
    public void displayStacks() {
        System.out.println("Stack:     " + this);
        System.out.println("Min Stack: " + minStack);
        System.out.println("-------------------------------");
    }
}

public class Solution02 extends Stack<Integer> {

    public static void main(String[] args) {
        StackMin myStack = new StackMin();
        try {
            myStack.push(4);
            myStack.push(3);
            myStack.push(6);
            myStack.displayStacks();
            /**
             *  Stack:     [4, 3, 6]
                Min Stack: [4, 3]
             */
            System.out.println(myStack.min()); //3
            
            
            myStack.push(1);
            myStack.push(1);
            myStack.displayStacks();
            /**
             *  Stack:     [4, 3, 6, 1, 1]
                Min Stack: [4, 3, 1, 1]
             */
            System.out.println(myStack.min()); //1
            
            
            myStack.push(2);
            myStack.pop();
            myStack.pop();
            myStack.displayStacks();
            /**
             *  Stack:     [4, 3, 6, 1]
                Min Stack: [4, 3, 1]
             */
            System.out.println(myStack.min()); //1
            
            
            myStack.pop();
            myStack.pop();
            myStack.pop();
            myStack.displayStacks();
            /**
             *  Stack:     [4]
                Min Stack: [4]
             */
            System.out.println(myStack.min()); //4
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
