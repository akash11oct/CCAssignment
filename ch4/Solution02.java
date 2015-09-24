package practice.CCAssignment.ch4;

/**
 *
 * @author Akash Gandotra
 */
public class Solution02 {
    
    /**
     * Create binary search tree with minimal height from a sorted 
     * (increasing order) array
     * @param arr sorted array
     * @return root of BST 
     */
    public TreeNode createBST(int[] arr){
        return createBST(arr, 0, arr.length-1);
    }
    
    /**
     * Create binary search tree with minimal height from a sorted 
     * (increasing order) array
     * 
     * This is a recursive procedure that creates a BST.
     * We simply designate the element at the middle as root.
     * We call the procedure recursively on the left half of the array and 
     * assign the result from that as left child. We do the same for right child.
     * @param arr sorted array
     * @param begin start index of array
     * @param end end index of array
     * @return root of BST
     */
    public TreeNode createBST(int[] arr, int begin, int end){
        if(arr == null || arr.length == 0 || begin > end)
            return null;
        
        //Find middle element
        int mid = (begin + end)/2;
        int val = arr[mid];
        TreeNode left = createBST(arr, begin, mid-1);
        TreeNode right = createBST(arr, mid+1, end);
        return new TreeNode(val, left, right);
    }

    public static void main(String args[]){
        Solution02 obj = new Solution02();
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        TreeNode root = obj.createBST(arr);
        System.out.println("Printing Tree in Level Order:");
        TreesNGraphsUtility.levelorder(root); 
        System.out.println();
        /*
        * Printing Tree in Level Order:
        * 5 2 7 1 3 6 8 4 9 
        */
    }    
}
