package practice.CCAssignment.ch4;

/**
 *
 * @author Akash Gandotra
 */
public class Solution05 {

    /**
     * This method validates a Binary Search Tree.
     * A Binary Search tree must satisfy the condition that all left nodes must
     * be less than or equal to the current node, which must be less than all
     * the right nodes.
     * 
     * @param root root of tree
     * @return true if binary search tree is valid
     */
    public boolean validateBST(TreeNode root) {
        return validateBST(root, Integer.MIN_VALUE , Integer.MAX_VALUE);
    }

    /**
     * This method validates a Binary Search Tree.
     * A Binary Search tree must satisfy the condition that all left nodes must
     * be less than or equal to the current node, which must be less than all
     * the right nodes.
     * 
     * The algorithm passes down the min and max values to satisfy above 
     * condition and validates the node and subtrees of the node recursively.
     * 
     * Time Complexity  : O(N) 
     * Space Complexity : O(log N) on a balanced tree
     * where N is the number of nodes
     * 
     * @param root root of tree
     * @param min minimum value
     * @param max maximum value
     * @return true if binary search tree is valid
     */
    public boolean validateBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }

        if(root.getData() > max || root.getData() <= min)
            return false;
        
        if(!validateBST(root.getLeft(), min, root.getData()))
            return false;
        
        if(!validateBST(root.getRight(), root.getData() , max))
            return false;
        
        return true;
    }
    
    
/*

         20
        / \
       /   \
      /     \
     15     22 
    / \     /
   10 18   21
  /       / \
 8       21  24

*/
    public static void main(String args[]){
        Solution05 obj = new Solution05();
        TreeNode one = new TreeNode(20);
        TreeNode two = new TreeNode(15);
        TreeNode three = new TreeNode(22);
        TreeNode four = new TreeNode(10);
        TreeNode five = new TreeNode(18);
        TreeNode six = new TreeNode(21);
        TreeNode seven = new TreeNode(8);
        TreeNode eight = new TreeNode(21);
        TreeNode nine = new TreeNode(24);
        one.setLeft(two);
        one.setRight(three);
        two.setLeft(four);
        two.setRight(five);
        three.setLeft(six);
        four.setLeft(seven);
        six.setLeft(eight);
        six.setRight(nine);
        System.out.println("Tree is a valid BST:" + obj.validateBST(one));
    }    
}
