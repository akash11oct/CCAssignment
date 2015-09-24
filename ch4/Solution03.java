package practice.CCAssignment.ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import practice.CCAssignment.ch2.ListNode;

/**
 * This class implements an algorithm to create a linked list of all nodes
 * at each depth (e.g. if you have a tree with depth D, you'll have D lists.
 * 
 * @author Akash Gandotra
 */
class ListOfDepths {
    
    List<ListNode> lists = null;
    TreeNode root = null;
    
    public ListOfDepths(TreeNode root){
        lists = new ArrayList<ListNode>();
        this.root = root;
    }

    /**
     * Create a linked list of all the nodes at each depth i.e. a list of D
     * linked lists, where D is the depth of tree.
     *
     * This is similar to level order traversal of tree but we somehow need to
     * demarcate the end of a level. For this, we use a dummy node that acts as
     * a differentiator of depths. We add one dummy node to queue after the root
     * node. As soon as we encounter this dummy node, we know that level has
     * changed, so we end the list of that level, initialize a blank list for
     * the next level and add a dummy node to the end of queue to demarcate the
     * next level. This is because in level order traversal, we add all nodes in
     * the next level to the queue by the time we traverse the nodes in the
     * current level.
     *
     */
    public void createListOfDepths() {
        TreeNode dummy = new TreeNode(-1);
        ListNode listInUse = null;
        Queue<TreeNode> nodequeue = new LinkedList<TreeNode>();
        if (root != null) {
            nodequeue.add(root);
            nodequeue.add(dummy);
        }
        while (!nodequeue.isEmpty()) {
            TreeNode next = nodequeue.remove();

            if (next == dummy) {
                if (listInUse == null) {
                    break;
                }
                listInUse.next = null;
                nodequeue.add(dummy);
                listInUse = null;
            } else {
                if (listInUse == null) {
                    listInUse = new ListNode(next.getData());
                    lists.add(listInUse);
                } else {
                    listInUse.next = new ListNode(next.getData());
                    listInUse = listInUse.next;
                }
                if (next.getLeft() != null) {
                    nodequeue.add(next.getLeft());
                }
                if (next.getRight() != null) {
                    nodequeue.add(next.getRight());
                }
            }
        }
    }

    /**
     * Print list of linked lists
     */
    public void printListOfDepths() {
        for (ListNode node : lists) {
            while (node != null) {
                System.out.print(node.val + " ");
                node = node.next;
            }
            System.out.println();
        }
    }
}

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
public class Solution03 {

    public static void main(String args[]) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        one.setLeft(two);
        one.setRight(three);
        two.setLeft(four);
        two.setRight(five);
        three.setLeft(six);
        four.setLeft(seven);
        six.setLeft(eight);
        six.setRight(nine);
        System.out.println("Printing Tree in Level Order:");
        TreesNGraphsUtility.levelorder(one);
        System.out.println();
        
        
        ListOfDepths obj = new ListOfDepths(one);
        System.out.println("Printing Lists of Depths:");
        obj.createListOfDepths();
        obj.printListOfDepths();
        /*
        * Printing Tree in Level Order:
        * 1 2 3 4 5 6 7 8 9 
        * Printing Lists of Depths:
        * 1 
        * 2 3 
        * 4 5 6 
        * 7 8 9 
        */
    }

}
