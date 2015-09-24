package practice.CCAssignment.ch3;

import java.util.ArrayList;
import java.util.Stack;
import practice.CCAssignment.ch3.StacksNQueuesUtility.*;

/**
 * This class implements a Stack of Plates. When one stack gets too high i.e.
 * exceeds the max capacity, we add another stack to our array of stacks.
 *
 * The push and pop work like they would for a normal stack. We keep track of
 * the stack in use and make sure we perform push and pop on this stack in use.
 * When this stack gets full or empty we switch to next or previous one and that
 * one becomes our stack in use.
 *
 * @author Akash Gandotra
 */
class StackOfPlates {

    //array of all stacks 
    ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>();

    //The stack in use
    Stack<Integer> stackInUse;
    Integer stackInUseID = -1;
    Integer maxCapacity;

    public StackOfPlates(int capacity) {
        maxCapacity = capacity;
    }

    /**
     * Push an item onto our stack of plates
     *
     * If we don't have any stack or when our stack in use gets full, we take a
     * fresh stack, assign it an ID to track it, and add it to our array of
     * stacks.
     *
     * We push the item onto the stack currently in use.
     *
     * @param item item to be pushed
     */
    public void push(int item) {
        if (stackInUse == null || stackInUse.size() == maxCapacity) {
            stackInUse = new Stack<Integer>();
            stackInUseID++;
            stacks.add(stackInUseID, stackInUse);
        }
        stackInUse.push(item);
    }

    /**
     * This method returns item at top of stack of plates as if it was one huge
     * stack.
     *
     * If we find that the stack currently in use is empty, we remove that stack
     * from our array, get the previous stack in array using id, and set that
     * stack to the one currently in use.
     *
     * We pop from the stack currently in use.
     *
     * @return item at top of stack of plates as if it was one stack.
     * @throws EmptyStackException
     */
    public Integer pop() throws EmptyStackException {
        /*Throw an exception for empty stack if we don't have any stacks in use
         * or if we popped everything and the first stack is also empty.
         */
        if (stackInUse == null || (stackInUse.isEmpty() && stackInUseID == 0)) {
            stackInUse = null;
            throw new EmptyStackException();
        }

        if (stackInUse.isEmpty()) {
            stacks.remove(stackInUse);
            stackInUseID--;
            stackInUse = stacks.get(stackInUseID);
            return pop();
        }
        return stackInUse.pop();
    }

    /**
     * This method pops an item from a particular stack. We simply retrieve the
     * stack using the index that works as the ID, and pop an item from that
     * stack.
     *
     * @param i index of stack in array of stacks.
     * @return item at top of stack at index i
     * @throws EmptyStackException
     */
    public Integer popAtIndex(int i) throws EmptyStackException {
        Stack<Integer> ithStack = stacks.get(i);
        if (ithStack == null || ithStack.empty()) {
            throw new EmptyStackException();
        }
        int val = ithStack.pop();
        return val;
    }

    /**
     * Display the contents of array of stacks at any moment.
     */
    public void displayStacks() {
        System.out.println("Stack of Plates");
        for (int i = 0; i < stacks.size(); i++) {
            System.out.println("Stack at index " + i + " : " + stacks.get(i));
        }
        System.out.println("-------------------------------");
    }
}

public class Solution03 {

    public static void main(String[] args) {
        StackOfPlates myStack = new StackOfPlates(4);
        try {
            myStack.push(10);
            myStack.push(5);
            myStack.push(8);
            myStack.push(2);
            myStack.push(6);
            myStack.push(4);
            myStack.displayStacks();
            /**
             * Stack of Plates 
             * Stack at index 0 : [10, 5, 8, 2] 
             * Stack at index 1 : [6, 4]
             */

            myStack.pop();
            myStack.pop();
            myStack.displayStacks();
            /**
             * Stack of Plates 
             * Stack at index 0 : [10, 5, 8, 2] 
             * Stack at index 1 : []
             */

            myStack.pop();
            myStack.pop();
            myStack.pop();
            myStack.pop();
            myStack.displayStacks();
            /**
             * Stack of Plates 
             * Stack at index 0 : [10, 5, 8, 2] 
             * Stack at index 1 : []
             */

//            myStack.pop(); //Stack is empty.
            myStack.push(10);
            myStack.push(5);
            myStack.push(8);
            myStack.push(2);
            myStack.push(6);
            myStack.push(4);
            myStack.push(9);
            myStack.push(11);
            myStack.push(14);
            myStack.push(3);
            myStack.displayStacks();
            /**
             * Stack of Plates 
             * Stack at index 0 : [10, 5, 8, 2] 
             * Stack at index 1 : [6, 4, 9, 11] 
             * Stack at index 2 : [14, 3]
             */

            myStack.popAtIndex(0);
            myStack.popAtIndex(1);
            myStack.popAtIndex(1);
            myStack.pop();
            myStack.displayStacks();
            /**
             * Stack of Plates 
             * Stack at index 0 : [10, 5, 8] 
             * Stack at index 1 : [6, 4] 
             * Stack at index 2 : [14]
             */

            myStack.pop();
            myStack.pop();
            myStack.displayStacks();
            /**
             * Stack of Plates 
             * Stack at index 0 : [10, 5, 8] 
             * Stack at index 1 : [6]
             */
            myStack.pop();
            myStack.pop();
            myStack.displayStacks();
            /**
             * Stack of Plates 
             * Stack at index 0 : [10, 5]
             */

            myStack.push(8);
            myStack.push(2);
            myStack.push(6);
            myStack.push(4);
            myStack.push(9);
            myStack.push(11);
            myStack.push(14);
            myStack.push(3);
            myStack.displayStacks();
            /**
             * Stack of Plates 
             * Stack at index 0 : [10, 5, 8, 2] 
             * Stack at index 1 : [6, 4, 9, 11] 
             * Stack at index 2 : [14, 3]
             */
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
