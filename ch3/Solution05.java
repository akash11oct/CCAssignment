package practice.CCAssignment.ch3;

import java.util.Stack;

/**
 * This class implements a stack that sorts itself whenever required.
 * 
 * @author Akash Gandotra
 */
class MyEasilySortedStack {
    
    Stack<Integer> myStack;
    
    MyEasilySortedStack(){
        myStack = new Stack<Integer>();
    }

    /**
     * Push an item onto stack.
     * @param item element to be pushed
     */
    public void push(int item) {
        myStack.push(item);
    }

    /**
     * Pop the element at top of stack.     * 
     * @return element at top of stack.
     */
    public Integer pop() {
        return myStack.pop();
    }


    /**
     * This method sorts a stack such that smallest elements are on top.
     * 
     * This method uses a temporary stack that we always keep sorted. Now we 
     * simply pop elements from our stack until our stack is empty and
     * push these elements to the sorted stack in order.
     */
    public void sortStack() {
        Stack<Integer> sorted = new Stack<Integer>();
        while (!myStack.isEmpty()) {
            int tmp = myStack.pop();
            while (!sorted.isEmpty() && sorted.peek() < tmp) {
                myStack.push(sorted.pop());
            }
            sorted.push(tmp);
        }
        myStack = sorted;
    }

    /**
     * Display the contents of myStack at any moment.
     */
    public void displayStack() {
        System.out.println("Stack: " + myStack);
        System.out.println("-------------------------------");
    }
}
public class Solution05 {

    public static void main(String args[]) {
        MyEasilySortedStack obj = new MyEasilySortedStack();
        obj.push(2);
        obj.push(4);
        obj.push(1);
        obj.push(7);
        obj.push(5);
        obj.displayStack(); //[2, 4, 1, 7, 5]
        obj.sortStack();
        obj.displayStack(); //[7, 5, 4, 2, 1]
    }
}