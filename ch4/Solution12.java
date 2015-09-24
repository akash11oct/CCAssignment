package practice.CCAssignment.ch4;

/**
 *
 * @author Akash Gandotra
 */
public class Solution12 {
    
    /**
     * This method counts the number of paths that sum to a given value. The 
     * path does not need to start or end at the root or a leaf, but it must
     * go downwards from parent to child nodes.
     * 
     * The algorithm runs recursively for each node and tracks the sum. When it
     * equals the target sum , we add the paths.
     * 
     * Time Complexity: O(n log n) for a balanced tree
     *  where n is the number of nodes in tree.
     * 
     * @param root root node of tree
     * @param sum target sum as given
     * @return number of paths that total up to given target sum
     */
    public int numPathsWithSum(TreeNode root, int sum){
        if(root == null)
            return 0;
        
        int pathsOnLeftSubtree = numPathsWithSum(root.getLeft(),sum);
        int pathsOnRightSubtree = numPathsWithSum(root.getRight(),sum);
        int pathsWithCurrNode = numPathsStartingFromNodeWithSum(root, sum, 0);
        int numPaths = pathsOnLeftSubtree+ pathsOnRightSubtree+ pathsWithCurrNode;
        return numPaths;
    }
    
    /**
     * This method counts the number of paths starting from this node that sum 
     * to a given value. 
     * 
     * @param root root node of tree
     * @param sum target sum as given
     * @param currSum current sum
     * @return number of paths that total up to given target sum
     */
    public int numPathsStartingFromNodeWithSum(TreeNode root, int sum, int currSum){
        if(root == null)
            return 0;
        int numPaths = 0;
        currSum = currSum + root.getData();
        if(sum == currSum)
            numPaths = 1;
        numPaths += numPathsStartingFromNodeWithSum(root.getLeft(), sum, currSum) + 
                    numPathsStartingFromNodeWithSum(root.getRight(), sum, currSum);
        return numPaths;
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
        Solution12 obj = new Solution12();
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
        System.out.println("Num of Paths with Sum of 7 =  " + obj.numPathsWithSum(one, 7)); //3
        //3 paths with sum = 7 : 1+2+4 ; 2+5 ; 7
    }       
    
}
