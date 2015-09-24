package practice.CCAssignment.ch4;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class implements an algorithm to compute possible arrays to build a BST.
 * 
 * A binary search tree can be created by traversing through an array from left
 * to right and inserting each element. 
 * Given a binary search tree with distinct elements, this class aims to compute
 * all possible arrays that can lead to this tree.
 * 
 * @author Akash Gandotra
 */
class BSTSequences {

    //Stores all possible sequences for this BST
    ArrayList<LinkedList<Integer>> allSeq;
    ArrayList<LinkedList<Integer>> temp;
    TreeNode rootNode;

    public BSTSequences(TreeNode root) {
        //stores the root node of binary search tree 
        rootNode = root;
    }

    public void computeAllBSTSequences() {
        allSeq = computeAllBSTSequences(rootNode);
    }

    /**
     * This method computes the BST Sequences in a recursive manner.
     * We call the method recursively on the left and right child nodes, get
     * the BST Sequences for them, and then merge those with the current node
     * data, keeping the current node data in the beginning, and then merging
     * the left child sequences with the right child sequences, while 
     * maintaining their relative order.
     * 
     * @param node starting node of tree
     * @return Sequences for BST
     */
    public ArrayList<LinkedList<Integer>> computeAllBSTSequences(TreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        if (node == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        LinkedList<Integer> pre = new LinkedList<Integer>();
        pre.add(node.getData());

        ArrayList<LinkedList<Integer>> leftSeqs = computeAllBSTSequences(node.getLeft());
        ArrayList<LinkedList<Integer>> rightSeqs = computeAllBSTSequences(node.getRight());

        for (LinkedList<Integer> s1 : leftSeqs) {
            for (LinkedList<Integer> s2 : rightSeqs) {
                temp = new ArrayList<LinkedList<Integer>>();
                mergeSequences(pre, s1, s2);
                result.addAll(temp);
            }
        }
        
        return result;
    }

    /**
     * This method merges the sequences while maintaining their relative order.
     * 
     * @param pre
     * @param leftSeq
     * @param rightSeq 
     */
    public void mergeSequences(
            LinkedList<Integer> pre,
            LinkedList<Integer> leftSeq,
            LinkedList<Integer> rightSeq) {

        //Either of the sequences are null or empty
        if ((leftSeq == null || leftSeq.size() == 0) || (rightSeq == null || rightSeq.size() == 0)) {
            LinkedList<Integer> seq = new LinkedList<Integer>();
            seq.addAll(pre);
            if (leftSeq != null && leftSeq.size() > 0) {
                seq.addAll(leftSeq);
            }
            if (rightSeq != null && rightSeq.size() > 0) {
                seq.addAll(rightSeq);
            }
            temp.add(seq);
            return;
        }

        int leftSeqHead = leftSeq.removeFirst();
        pre.addLast(leftSeqHead);
        mergeSequences(pre, leftSeq, rightSeq);
        pre.removeLast();
        leftSeq.addFirst(leftSeqHead);

        int rightSeqHead = rightSeq.removeFirst(); 
        pre.addLast(rightSeqHead);
        mergeSequences(pre, leftSeq, rightSeq);
        pre.removeLast();
        rightSeq.addFirst(rightSeqHead);
    }

    /**
     * Print all BST Sequences
     */
    public void printAllBSTSequences() {
        StringBuilder sb = null;
        for (LinkedList<Integer> seq : allSeq) {
            sb = new StringBuilder();
            sb.append("{");
            for (int i : seq) {
                sb.append(i + ", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("}");
            System.out.println(sb.toString());
        }
    }
}

public class Solution09 {

   /*
    
             1
            / \
           /   \
          /     \
         2       3
        / \     
       4   5   
    */
    public static void main(String args[]) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        one.setLeft(two);
        one.setRight(three);
        two.setLeft(four);
        two.setRight(five);

        BSTSequences obj = new BSTSequences(one);
        obj.computeAllBSTSequences();
        obj.printAllBSTSequences();
        /**
         *  {1, 2, 4, 5, 3}
            {1, 2, 4, 3, 5}
            {1, 2, 3, 4, 5}
            {1, 3, 2, 4, 5}
            {1, 2, 5, 4, 3}
            {1, 2, 5, 3, 4}
            {1, 2, 3, 5, 4}
            {1, 3, 2, 5, 4}
         */
    }

}
