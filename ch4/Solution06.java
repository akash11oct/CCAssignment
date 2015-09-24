package practice.CCAssignment.ch4;

/**
 *
 * @author Akash Gandotra
 */
public class Solution06 {

    /**
     * This method finds the in-order successor of a given node in a binary 
     * search tree.
     * 
     * Time Complexity: O(h) where h is the height of tree.
     * 
     * @param node node to find the successor for.
     * @return in-order successor of node
     */
    public TreeNodeWP findInorderSuccessor(TreeNodeWP node) {
        if (node == null) {
            return null;
        }
        
        TreeNodeWP succ = null;
        if(node.right != null){ 
            /*
             * if n has a right subtree
             * return leftmost child of right subtree
             */
            succ = node.right;
            while(succ.left != null)
                succ = succ.left;
        }
        else{
            /*
             * while n is a right child of n's parent
             * assign n to n's parent
             */
            while(node.parent != null && node.parent.right == node){
                node = node.parent;
            }
            succ = node.parent; //The parent is the successor
        }
        return succ;
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
        Solution06 obj = new Solution06();
        TreeNodeWP one = new TreeNodeWP(1);
        TreeNodeWP two = new TreeNodeWP(2);
        TreeNodeWP three = new TreeNodeWP(3);
        TreeNodeWP four = new TreeNodeWP(4);
        TreeNodeWP five = new TreeNodeWP(5);
        TreeNodeWP six = new TreeNodeWP(6);
        TreeNodeWP seven = new TreeNodeWP(7);
        TreeNodeWP eight = new TreeNodeWP(8);
        TreeNodeWP nine = new TreeNodeWP(9);
        one.setLeft(two);
        one.setRight(three);
        two.setLeft(four);
        two.setRight(five);
        three.setLeft(six);
        four.setLeft(seven);
        six.setLeft(eight);
        six.setRight(nine);
        //Inorder Traversal :  7 4 2 5 1 8 6 9 3
        System.out.println("Inoder Successor for 1: " + obj.findInorderSuccessor(one));
        System.out.println("Inoder Successor for 2: " + obj.findInorderSuccessor(two));
        System.out.println("Inoder Successor for 3: " + obj.findInorderSuccessor(three));
        System.out.println("Inoder Successor for 4: " + obj.findInorderSuccessor(four));
        System.out.println("Inoder Successor for 5: " + obj.findInorderSuccessor(five));
        System.out.println("Inoder Successor for 6: " + obj.findInorderSuccessor(six));
        System.out.println("Inoder Successor for 7: " + obj.findInorderSuccessor(seven));
        System.out.println("Inoder Successor for 8: " + obj.findInorderSuccessor(eight));
        System.out.println("Inoder Successor for 9: " + obj.findInorderSuccessor(nine));
    }    
}

