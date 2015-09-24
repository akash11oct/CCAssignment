package practice.CCAssignment.ch3;

import java.util.Stack;

/**
 * This class implement a Queue using two stacks.
 * 
 * The class uses two stacks: one to store elements in FIFO order like queue
 * and another to store elements in LIFO order like a stack.
 * 
 * As long as we push elements onto stack, we keep using the LIFO stack. But, 
 * when we need to pop, if we pop from LIFO stack, we will get the last element
 * pushed. Since, we need queue-like functionality, we need the first element
 * pushed. So, we pop all elements from LIFO Stack and push them onto the other
 * one. Now we have oldest element on Top. We simply return the element on top
 * of this stack.
 * 
 * So, we always push on the stack with latest elements on top. 
 * 
 * We always pop from stack with oldest elements on top. If this stack gets
 * empty, we transfer elements from the other stack to this one and continue.
 * 
 * @author Akash Gandotra
 */
class MyQueue<T> {

    Stack<T> stackWithLatestOnTop;
    Stack<T> stackWithOldestOnTop;
    int size;

    public MyQueue() {
        stackWithLatestOnTop = new Stack<T>();
        stackWithOldestOnTop = new Stack<T>();
        size = 0;
    }

    /**
     * Return the size of queue.
     * @return the size of queue.
     */
    public int size() {
        return size;
    }

    /**
     * Enqueue elements into our pretend queue.
     * Push the element on top of stack with latest elements on top.
     * Increment size of queue.
     * 
     * @param data element to be enqueued
     */
    public void enqueue(T data) {
        stackWithLatestOnTop.push(data);
        size++;
    }

    /**
     * Dequeue element from our pretend queue.
     * 
     * Pop from stack with oldest elements on top. If this stack gets empty, 
     * transfer elements from the other stack to this one and continue.
     * 
     * @return element from queue in FIFO order.
     */
    public T dequeue() {
        if (size == 0) {
            return null;
        }
        if (stackWithOldestOnTop.isEmpty()) {
            reverseStacks();
        }
        T data = stackWithOldestOnTop.pop();
        size--;
        return data;
    }

    /**
     * Peek into queue.
     * 
     * Return from stack with oldest elements on top. If this stack gets empty, 
     * transfer elements from the other stack to this one and continue.
     * 
     * @return element from queue in FIFO order.
     */
    public T peek() {
        if (size == 0) {
            return null;
        }
        if (stackWithOldestOnTop.isEmpty()) {
            reverseStacks();
        }
        T data = stackWithOldestOnTop.peek();
        return data;
    }

    /**
     * Transfer elements from stack with latest elements on top to the FIFO 
     * stack in reverse order i.e. keep popping elements from one and pushing 
     * them onto the other.
     */
    private void reverseStacks() {
        while (!stackWithLatestOnTop.isEmpty()) {
            stackWithOldestOnTop.push(stackWithLatestOnTop.pop());
        }
    }

    /**
     * Display the contents of both stacks at any moment.
     */
    public void displayStacks() {
        System.out.println("stackWithLatestOnTop:  " + stackWithLatestOnTop);
        System.out.println("stackWithOldestOnTop:  " + stackWithOldestOnTop);
        System.out.println("-------------------------------");
    }
}

public class Solution04 {   

    public static void main(String args[]) {
        MyQueue<Integer> myQ = new MyQueue<Integer>();
        myQ.enqueue(2);
        myQ.enqueue(4);
        myQ.enqueue(1);
        myQ.enqueue(7);
        myQ.enqueue(5);
        myQ.displayStacks();
        /**
         *  stackWithLatestOnTop:  [2, 4, 1, 7, 5]
            stackWithOldestOnTop:  []
         */
        
        System.out.println("Dequeue: " + myQ.dequeue()); //2
        myQ.displayStacks();
        /**
         *  stackWithLatestOnTop:  []
            stackWithOldestOnTop:  [5, 7, 1, 4]
         */
        
        
        System.out.println("Peek: " + myQ.peek()); //4
        System.out.println("Dequeue: " + myQ.dequeue()); //4
        System.out.println("Dequeue: " + myQ.dequeue()); //4
        System.out.println("Peek: " + myQ.peek()); //7
        myQ.enqueue(6);
        myQ.enqueue(8);
        myQ.displayStacks();
        /**
         *  stackWithLatestOnTop:  [6, 8]
            stackWithOldestOnTop:  [5, 7]
         */
        
        
        System.out.println("Dequeue: " + myQ.dequeue()); //7
        System.out.println("Dequeue: " + myQ.dequeue()); //5
        System.out.println("Peek: " + myQ.peek()); //6
        myQ.displayStacks();
        /**
         *  stackWithLatestOnTop:  []
            stackWithOldestOnTop:  [8, 6]
         */
        
        
    }
}