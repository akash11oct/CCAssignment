package practice.CCAssignment.ch4;

import practice.CCAssignment.ch4.TreesNGraphsUtility.State;

/**
 *
 * @author Akash Gandotra
 */
public class Solution08 {

    /**
     * This method finds common ancestor for two nodes that have links to the 
     * parent node.
     * 
     * We go up to the root from nodeA marking each node as Visited.
     * Then, we go up from nodeB to the root. If we find a node that is already
     * marked Visited, then we return that node as common ancestor.
     * 
     * Time Complexity: O(h) where h is the height of tree.
     * 
     * @param nodeA first node
     * @param nodeB second node
     * @return common ancestor for the two nodes
     */
    public TreeNodeWP findFirstCommonAncestor(TreeNodeWP nodeA, TreeNodeWP nodeB) {
        if(nodeA == nodeB)
            return nodeA;
        
        while(nodeA != null){
            nodeA.state = State.Visited;
            nodeA = nodeA.parent;
        }
        while(nodeB != null){
            if(nodeB.state == State.Visited)
                return nodeB;
            nodeB = nodeB.parent;
        }
        return null;
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
        Solution08 obj = new Solution08();
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
        TreeNodeWP[] nodes = new TreeNodeWP[]{one, two, three, four, five, six, seven, eight, nine};
        System.out.println("Common Ancestor for 1,5: " + obj.findFirstCommonAncestor(one, five));
        TreesNGraphsUtility.resetState(nodes);
        System.out.println("Common Ancestor for 2,3: " + obj.findFirstCommonAncestor(two, three));
        TreesNGraphsUtility.resetState(nodes);
        System.out.println("Common Ancestor for 3,1: " + obj.findFirstCommonAncestor(three, one));
        TreesNGraphsUtility.resetState(nodes);
        System.out.println("Common Ancestor for 4,5: " + obj.findFirstCommonAncestor(four, five));
        TreesNGraphsUtility.resetState(nodes);
        System.out.println("Common Ancestor for 5,5: " + obj.findFirstCommonAncestor(five, five));
        TreesNGraphsUtility.resetState(nodes);
        System.out.println("Common Ancestor for 6,9: " + obj.findFirstCommonAncestor(six, nine));
        TreesNGraphsUtility.resetState(nodes);
        System.out.println("Common Ancestor for 7,5: " + obj.findFirstCommonAncestor(seven, five));
        TreesNGraphsUtility.resetState(nodes);
        System.out.println("Common Ancestor for 8,9: " + obj.findFirstCommonAncestor(eight, nine));
        TreesNGraphsUtility.resetState(nodes);
        System.out.println("Common Ancestor for 9,7: " + obj.findFirstCommonAncestor(nine, seven));
        TreesNGraphsUtility.resetState(nodes);
    }    
}

