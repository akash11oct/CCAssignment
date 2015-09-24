package practice.CCAssignment.ch4;

import java.util.Random;

/**
 * This class implements a binary tree which has a method getRandomNode() that
 * returns a random node from the tree.
 * All nodes are equally likely to be chosen.
 * 
 * This algorithm makes sure that we keep track of the size of the nodes
 * on the left and on the right. We save this information in each node in the
 * size variable.
 * 
 * Each node must have an equal probability which means that we must pick from
 * the left with a probability of left_size * 1/N.
 * 
 * Time Complexity: O(log N), where N is the number of nodes.
 * 
 * @author Akash Gandotra
 */
class MyTreeNode {

    MyTreeNode left;
    MyTreeNode right;
    int data;
    int size;

    public MyTreeNode(int data) {
        this.data = data;
        size = 1;
    }
    
    /**
     * Insert data into tree.
     * Increment size to keep track of size.
     * @param data value to be inserted
     */
    public void insertNode(int data){
        if(data <= this.data){
            if(left == null)
                left = new MyTreeNode(data);
            else
                left.insertNode(data);
        }
        else{
            if(right == null)
                right = new MyTreeNode(data);
            else
                right.insertNode(data);            
        }
        size++;
    }
    
    /**
     * Find value in tree.
     * @param data value to be found
     * @return Node containing value
     */
    public MyTreeNode findNode(int data){
        if(this.data == data)
            return this;
        if(data <= this.data && left != null)
            return left.findNode(data);
        if(data > this.data && right != null)
            return right.findNode(data);
        return null;
    }
    
    /**
     * Get a random node from tree.
     * @return a random node from tree.
     */
    public MyTreeNode getRandomNode(){
        int leftSize = 0;
        if(left != null)
            leftSize = left.size;
        
        Random rd = new Random();
        int index = rd.nextInt(size);
        if(index < leftSize)
            return left.getRandomNode();
        if(index == leftSize)
            return this;
        return right.getRandomNode();
    }
    
    public int getData() {
        return data;
    }

    public MyTreeNode getLeft() {
        return this.left;
    }

    public void setLeft(MyTreeNode left) {
        this.left = left;
    }

    public MyTreeNode getRight() {
        return this.right;
    }

    public void setRight(MyTreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "" + data;
    }
}

public class Solution11 {

    /*
    
             1
            / \
           /   \
          /     \
         2       3
        / \     /
       4   5   6
      /       / \
     7       8   9
    */
    public static void main(String args[]){        
        MyTreeNode myTree = new MyTreeNode(1);
        myTree.insertNode(2);
        myTree.insertNode(3);
        myTree.insertNode(4);
        myTree.insertNode(5);
        myTree.insertNode(6);
        myTree.insertNode(7);
        myTree.insertNode(8);
        myTree.insertNode(9);
        System.out.println("Printing Tree in Order:");
        TreesNGraphsUtility.inorder(myTree);
        System.out.println();
        System.out.println("Random Node : " + myTree.getRandomNode()); //2
        System.out.println("Random Node : " + myTree.getRandomNode()); //9
        System.out.println("Random Node : " + myTree.getRandomNode()); //7
        System.out.println("Random Node : " + myTree.getRandomNode()); //8
    }       
}