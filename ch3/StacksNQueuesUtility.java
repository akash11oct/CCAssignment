/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice.CCAssignment.ch3;

/**
 * This class implements utility classes and methods for stacks and queues.
 * 
 * @author Akash Gandotra
 */
public class StacksNQueuesUtility {

    public static class FullStackException extends Exception {

        /**
         * Returns the detail message string of this exception.
         *
         * @return the message
         */
        @Override
        public String getMessage() {
            return "Stack is full.";
        }
    }

    public static class EmptyStackException extends Exception {

        /**
         * Returns the detail message string of this exception.
         *
         * @return the message
         */
        @Override
        public String getMessage() {
            return "Stack is empty.";
        }
    }

}
