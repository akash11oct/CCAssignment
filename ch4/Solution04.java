package practice.CCAssignment.ch4;

/**
 *
 * @author Akash Gandotra
 */
public class Solution04 {
    
    /**
     * Returns true if binary tree is balanced.
     * A balanced tree is defined to be a tree such that the heights of the two 
     * subtrees of any node never differs by more than one.
     * 
     * @param root root of tree
     * @return true if binary tree is balanced.
     */
    public boolean isTreeBalanced(TreeNode root){
        return (checkTreeBalanced(root) != -1);
    }
    
    /**
     * Checks if binary tree is balanced.
     * A balanced tree is defined to be a tree such that the heights of the two 
     * subtrees of any node never differs by more than one.
     * 
     * This method checks the height of each subtree recursively. For each node,
     * we obtain the height of both subtrees as a return parameter through this
     * method. We return the height only if the subtree we are checking in the 
     * method is balanced. If not, we return -1.
     * 
     * @param root root of tree
     * @return true if binary tree is balanced.
     */
    public int checkTreeBalanced(TreeNode root){
        if(root == null)
            return 0;
        
        int heightLeftSubTree = checkTreeBalanced(root.getLeft());
        if(heightLeftSubTree == -1)
            return -1;
        
        int heightRightSubTree = checkTreeBalanced(root.getRight());
        if(heightRightSubTree == -1)
            return -1;
        
        int dif = heightRightSubTree - heightLeftSubTree;
        if(dif>1)
            return -1;
        
        int height = 1 + Math.max(heightLeftSubTree, heightRightSubTree);
        return height;
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
    public static void main(String args[]){
        Solution04 obj = new Solution04();
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
        System.out.println("Tree is balanced:" + obj.isTreeBalanced(one));
    }    
}
