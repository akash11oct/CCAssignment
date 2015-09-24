package practice.CCAssignment.ch3;

import practice.CCAssignment.ch3.StacksNQueuesUtility.*;

/**
 * 
 * This class implements three stacks using one array.
 * Keep 0,1,2 as stack tops for three stacks and increment/decrement the top 
 * by 3 while pushing/popping.
 * 
 * @author Akash Gandotra
 */
class ThreeInOne {

    private int[] arr;
    private int[] stackTop = new int[]{-3, -2, -1};
    private int numberOfStacks = 3;
    private int stackCapacity;

    /** 
     * Creates a new object of class 
     * @param stackSize capacity of one stack
     */
    public ThreeInOne(int stackSize) {
        stackCapacity = stackSize;
        arr = new int[stackCapacity * numberOfStacks];
    }

    /**
     * Push a value to a particular stack
     * Increment the particular stack top by 3 and push the value in the array
     * at this position.
     * 
     * @param stackNum denotes which stack to push item onto
     * @param value item to be pushed
     * @throws FullStackException 
     */
    public void push(int stackNum, int value) throws FullStackException {
        if (isFull(stackNum)) {
            System.out.println("Caught Exception for Stack " + stackNum);
            throw new FullStackException();
        }
        stackTop[stackNum] = stackTop[stackNum] + 3;
        arr[stackTop[stackNum]] = value;
    }

    /**
     * Pop value from particular stack.
     * Return value from array at position denoted by the particular stack top.
     * Decrement the stack top by 3.
     *
     * @param stackNum stack to pop from
     * @return value on top of particular stack
     * @throws EmptyStackException 
     */
    public int pop(int stackNum) throws EmptyStackException {
        if (isEmpty(stackNum)) {
            System.out.println("Caught Exception for Stack " + stackNum);
            throw new EmptyStackException();
        }
        int val = arr[stackTop[stackNum]];
        stackTop[stackNum] = stackTop[stackNum] - 3;
        return val;
    }

    /**
     * Peek value at top of particular stack.
     * Return value from array at position denoted by the particular stack top.
     * 
     * @param stackNum stack to pop from
     * @return value on top of particular stack
     * @throws EmptyStackException 
     */
    public int peek(int stackNum) throws EmptyStackException {
        if (isEmpty(stackNum)) {
            System.out.println("Caught Exception for Stack " + stackNum);
            throw new EmptyStackException();
        }
        return arr[stackTop[stackNum]];
    }

    public boolean isEmpty(int stackNum) {
        return stackTop[stackNum] < 0;
    }

    public boolean isFull(int stackNum) {
        return stackTop[stackNum] >= (stackCapacity-1)*3;
    }

    /**
     * Display the contents of array at any moment.
     */
    public void displayStacks() {
        System.out.println("Print Stack array");
        for(int i=0; i<arr.length; i++)
            System.out.print(arr[i] + "  ");
        System.out.println("\n-------------------------------");
    }
}

public class Solution01 {

    public static void main(String[] args) {
        ThreeInOne myStack = new ThreeInOne(5);
        try {
            myStack.push(0, 1);
            myStack.push(0, 2);
            myStack.push(1, 3);
            myStack.push(1, 4);
            myStack.push(2, 5);
            myStack.push(0, 6);
            myStack.displayStacks();
            //1  3  5  2  4  0  6  0  0  0  0  0  0  0  0  
            System.out.println(myStack.peek(1));
            System.out.println(myStack.peek(0));
            myStack.pop(0);
            myStack.pop(0);
            myStack.push(0, 7);
            System.out.println(myStack.peek(0));
            myStack.pop(1);
            myStack.pop(2);
            System.out.println(myStack.peek(1));
            myStack.push(2, 8);
            myStack.push(2, 9);
            myStack.displayStacks();
            //1  3  8  7  4  9  6  0  0  0  0  0  0  0  0   
            myStack.pop(1);
            myStack.push(0, 1);
            myStack.push(0, 2);
            System.out.println(myStack.peek(0));
            myStack.pop(0);
            myStack.push(0, 2);
            myStack.push(1, 3);
            myStack.push(1, 4);
            myStack.displayStacks();
            //1  3  8  7  4  9  1  0  0  2  0  0  0  0  0  
            System.out.println(myStack.peek(0));
            myStack.push(2, 5);
            myStack.pop(1);
            myStack.pop(2);
            myStack.pop(2);
            myStack.pop(2);
            myStack.push(2, 8);
            System.out.println( myStack.peek(2));
            myStack.push(2, 9);
            System.out.println(myStack.peek(2));
            myStack.displayStacks();
            //1  3  8  7  4  9  1  0  5  2  0  0  0  0  0  
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
