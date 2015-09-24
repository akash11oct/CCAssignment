package practice.CCAssignment.ch4;

import java.util.Queue;
import java.util.LinkedList;
/**
 *
 * @author Akash Gandotra
 */
public class TreesNGraphsUtility {
    
    enum State{ Unvisited, Visiting, Visited}
    
    public static int heightOfTree(TreeNode root){
        if(root == null)
            return 0;
        
        int heightLeftSubTree = heightOfTree(root.getLeft());
        int heightRightSubTree = heightOfTree(root.getRight());
        int height = 1 + Math.max(heightLeftSubTree, heightRightSubTree);
        return height;
    }

    public static void preorder(TreeNode n) {
        if (n != null) {
            System.out.print(n.getData() + " ");
            preorder(n.getLeft());
            preorder(n.getRight());
        }
    }

    public static void inorder(TreeNode n) {
        if (n != null) {
            inorder(n.getLeft());
            System.out.print(n.getData() + " ");
            inorder(n.getRight());
        }
    }

    public static void postorder(TreeNode n) {
        if (n != null) {
            postorder(n.getLeft());
            postorder(n.getRight());
            System.out.print(n.getData() + " ");
        }
    }

    public static void levelorder(TreeNode n) {
        Queue<TreeNode> nodequeue = new LinkedList<TreeNode>();
        if (n != null) {
            nodequeue.add(n);
        }
        while (!nodequeue.isEmpty()) {
            TreeNode next = nodequeue.remove();
            System.out.print(next.getData() + " ");
            if (next.getLeft() != null) {
                nodequeue.add(next.getLeft());
            }
            if (next.getRight() != null) {
                nodequeue.add(next.getRight());
            }
        }
    }   
    
    public static void resetState(TreeNodeWP[] nodes){
        for(TreeNodeWP node: nodes){
            node.state = State.Unvisited;
        }
    }
    
}
