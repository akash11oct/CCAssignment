package practice.CCAssignment.ch10;

/**
 *
 * @author Akash Gandotra
 */
public class Solution09 {
    
    /**
     * Search a sorted matrix - an MxN matrix in which each row and each column 
     * is sorted in ascending order.
     * 
     * @param arr sorted matrix
     * @param value value to search for
     * @return true if value exists in matrix
     */
    public static boolean searchSortedMatrix(int[][] arr, int value){
        int re = arr.length-1;
        int ce = arr[0].length-1;
        if(value < arr[0][0] || value > arr[re][ce])
            return false;
        
        return searchSortedMatrix(arr, value, 0, re, 0, ce);
    }
    
    /**
     * Search a sorted matrix - an MxN matrix in which each row and each column 
     * is sorted in ascending order.
     * 
     * This algorithm is similar to binary search. First, we search along the
     * diagonal, starting from the end, to find an element which is less than
     * the value we are searching for.
     * At this point, we can divide the array into four pieces. The elements in
     * upper left quadrant are all smaller than the value we are looking for and
     * the elements in lower right quadrant are all greater than the value we 
     * are looking for. So, we ignore these two and search recursively in the
     * other two quadrants.
     * 
     * @param arr sorted matrix
     * @param value value to search for
     * @param rb
     * @param re
     * @param cb
     * @param ce
     * @return true if value exists in matrix
     */
    public static boolean searchSortedMatrix(int[][] arr, int value, int rb, int re, int cb, int ce){
        if(rb > re || cb > ce)
            return false;
        
        /**
         * search along the diagonal, starting from the end, to find an element 
         * which is less than the value we are searching for.
         */
        int rm = re;
        int cm = ce;
        while(rm >=rb && cm >= cb){            
            if(value == arr[rm][cm])
                return true;
            if(value > arr[rm][cm])
                break;
            rm--;
            cm--;
        }
        
        /**
         * search recursively in the upper right and lower left quadrants.
         */
        return searchSortedMatrix(arr , value, rb, rm, cm+1, ce) || searchSortedMatrix(arr , value, rm+1, re, cb, cm);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{
            {15, 20, 70, 85},
            {20, 35, 80, 95},
            {30, 55, 95, 105},
            {40, 80, 120, 120}};
        
        //Check for all elements present
        System.out.println(searchSortedMatrix(arr,15));  //true
        System.out.println(searchSortedMatrix(arr,20));  //true
        System.out.println(searchSortedMatrix(arr,70));  //true
        System.out.println(searchSortedMatrix(arr,85));  //true
        System.out.println(searchSortedMatrix(arr,35));  //true
        System.out.println(searchSortedMatrix(arr,80));  //true
        System.out.println(searchSortedMatrix(arr,95));  //true
        System.out.println(searchSortedMatrix(arr,30));  //true
        System.out.println(searchSortedMatrix(arr,55));  //true
        System.out.println(searchSortedMatrix(arr,105)); //true
        System.out.println(searchSortedMatrix(arr,40));  //true
        System.out.println(searchSortedMatrix(arr,120)); //true
        
        System.out.println();
        
        //Check for various elements not present
        System.out.println(searchSortedMatrix(arr,151)); //false
        System.out.println(searchSortedMatrix(arr,21));  //false
        System.out.println(searchSortedMatrix(arr,71));  //false
        System.out.println(searchSortedMatrix(arr,34));  //false
        System.out.println(searchSortedMatrix(arr,81));  //false
        System.out.println(searchSortedMatrix(arr,31));  //false
        System.out.println(searchSortedMatrix(arr,56));  //false
        System.out.println(searchSortedMatrix(arr,5));   //false
        System.out.println(searchSortedMatrix(arr,41));  //false
        System.out.println(searchSortedMatrix(arr,119)); //false
    }
    
}
