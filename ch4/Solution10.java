package practice.CCAssignment.ch4;

/**
 *
 * @author Akash Gandotra
 */
public class Solution10 {

    /**
     * This method checks to see if tree t2 is a subtree of tree t1.
     * A tree t2 is a subtree of t1 if there exists a node n in t1 such that the
     * subtree of n is identical to t2. That is, if you cut off the tree at 
     * node n, the two trees would be identical.
     * 
     * This method recursively tests this by checking to see if t2 is not 
     * identical to t1, then if t2 is a subtree of either of the subtrees of t1.
     * 
     * Time Complexity  : O(log n + log m) 
     * Space Complexity : worst case of O(nm); far more optimal on average.
     * where n and m are the number of nodes in t1 and t2.
     * 
     * @param t1 the larger tree
     * @param t2 the smaller tree 
     * @return true if tree t2 is a subtree of tree t1
     */
    public boolean checkSubtree(TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) 
            return false;
        
        //Return true if both trees are identical
        if (checkIdentical(t1, t2))
            return true;
        
        //Return true if t2 is a subtree of t1's left subtree
        if (t1.getLeft() != null && checkSubtree(t1.getLeft(), t2))
            return true;
        
        //Return true if t2 is a subtree of t1's right subtree        
        if (t1.getRight() != null && checkSubtree(t1.getRight(), t2))
            return true;
        
        return false;
    }

    /**
     * This method checks to see if two trees t1 and t2 are identical.
     * 
     * This method recursively tests this by checking if t1 and t2 have same 
     * values in current nodes and also have identical left and right subtrees.
     * 
     * @param t1 the larger tree
     * @param t2 the smaller tree 
     * @return true if t1 and t2 are identical
     */
    public boolean checkIdentical(TreeNode t1, TreeNode t2) {

        //Return true if both are null
        if (t1 == null && t2 == null) {
            return true;
        }

        //Return false if one tree is null or their current nodes have 
        //different values
        if (t1 == null || t2 == null || t1.getData() != t2.getData()) {
            return false;
        }

        //Return false if t1's left subtree is not identical to t2's left subtree
        if (!checkIdentical(t1.getLeft(), t2.getLeft())) {
            return false;
        }

        //Return false if t1's left subtree is not identical to t2's left subtree
        if (!checkIdentical(t1.getRight(), t2.getRight())) {
            return false;
        }

        return true;
    }
    
    /*
    T1
             1
            / \
           /   \
          /     \
         2       3
        / \     /
       4   5   6
      /       / \
     7       8   9

    T2   2  
        / \ 
       4   5
    
    T3
         2 
        / \     
       4   5  
      /       
     7 
    
    T4
       6
      / \
     8   9
    */
    public static void main(String args[]) {
        Solution10 obj = new Solution10();
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
        System.out.println("Printing Tree T1 in Inorder:");
        TreesNGraphsUtility.inorder(one);  //7 4 2 5 1 8 6 9 3 
        System.out.println();        
        
        TreeNode twoNew = new TreeNode(2);
        TreeNode fourNew = new TreeNode(4);
        TreeNode fiveNew = new TreeNode(5);
        twoNew.setLeft(fourNew);
        twoNew.setRight(fiveNew);
        System.out.println("Printing Tree T2 in Inorder:");
        TreesNGraphsUtility.inorder(twoNew);  //4 2 5 
        System.out.println();        
        
        System.out.println("Check if T2 is a subtree  of T1:" + obj.checkSubtree(one,twoNew)); //false
        System.out.println();
        
        TreeNode sevenNew = new TreeNode(7);
        fourNew.setLeft(sevenNew);
        System.out.println("Printing Tree T3 in Inorder:");
        TreesNGraphsUtility.inorder(twoNew); //7 4 2 5 
        System.out.println();
        
        System.out.println("Check if T3 is a subtree  of T1:" + obj.checkSubtree(one,twoNew)); //true
        System.out.println();
        
        TreeNode sixNew = new TreeNode(6);
        TreeNode eightNew = new TreeNode(8);
        TreeNode nineNew = new TreeNode(9);
        sixNew.setLeft(eightNew);
        sixNew.setRight(nineNew);
        System.out.println("Printing Tree T4 in Inorder:");
        TreesNGraphsUtility.inorder(sixNew); //8 6 9 
        System.out.println();        
        
        System.out.println("Check if T4 is a subtree  of T1:" + obj.checkSubtree(one,sixNew)); //true
        System.out.println();
    }

}
